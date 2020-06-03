package com.itsq.service.resources.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itsq.common.bean.ErrorEnum;
import com.itsq.common.constant.APIException;
import com.itsq.pojo.entity.Manager;
import com.itsq.pojo.entity.Players;
import com.itsq.mapper.PlayersMapper;
import com.itsq.pojo.entity.User;
import com.itsq.service.resources.PlayersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itsq.utils.MD5;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 史先帅
 * @since 2020-06-02
 */
@Service
public class
PlayersServiceImpl extends ServiceImpl<PlayersMapper, Players> implements PlayersService {

    @Override
    public Players addPlayers(Players players) {

        Players players1 = selectPlayers(players.getNumber());

        if(players1!=null){
            throw new APIException(ErrorEnum.PLAYER_PHONE);
        }
        players.setPwd(MD5.getMd5(players.getPwd(),32));
        super.baseMapper.insert(players);
        return  players;
    }

    @Override
    public Players selectPlayers(String number) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("number",number);
        return super.baseMapper.selectOne(queryWrapper);
    }

    @Override
    public int updatePlayersBuId(Players players) {
        return super.baseMapper.updateById(players);
    }

    @Override
    public int updatePlayers(String number ,String pwd) {
        Players players= selectPlayers(number);

        if(players==null){
            throw new APIException(ErrorEnum.USER_NOT_EXITES);
        }
        QueryWrapper queryWrapper=new QueryWrapper();
        players.setPwd(MD5.getMd5(pwd,32));
        queryWrapper.eq("number",players.getNumber());

        return  super.baseMapper.update(players,queryWrapper);
    }

    @Override
    public Players login(String number, String pwd) {

        Optional<Players> u = super.lambdaQuery().eq(Players::getNumber,number).eq(Players::getPwd,MD5.getMd5(pwd,32)).oneOpt();
        if (u.isPresent()) {
            return u.get();
        }
        throw new APIException(ErrorEnum.USER_NOT_EXITES);
    }
}