package com.itsq.controller.resources;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itsq.common.base.BaseController;
import com.itsq.common.bean.ErrorEnum;
import com.itsq.common.bean.Response;
import com.itsq.pojo.dto.AddArmsDto;
import com.itsq.pojo.dto.BoxArmsSeachDto;
import com.itsq.pojo.entity.Arms;
import com.itsq.pojo.entity.OperationRecord;
import com.itsq.service.resources.ArmsService;
import com.itsq.service.resources.OperationRecordService;
import com.itsq.token.CurrentUser;
import com.itsq.utils.BeanUtils;
import com.itsq.utils.http.Client;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/arms")
@CrossOrigin
@Api(tags = "获取武器相关接口")
@AllArgsConstructor
public class ArmsController extends BaseController {
    @Autowired
    private Client client;
    private ArmsService armsService;

    @Autowired
    private OperationRecordService operationRecordService;


    @RequestMapping(value = "getAll", method = RequestMethod.POST)
    @ApiOperation(value = "获取全部武器", notes = "", httpMethod = "POST")
    public Response getAllArms(@RequestBody Arms arms) {
        Page<Arms> page=new Page(arms.getPageIndex(),arms.getPageSize());

        QueryWrapper queryWrapper = new QueryWrapper();
        if (arms.getName() != null && arms.getName().length() > 0) {
            queryWrapper.like("name", arms.getName());
        }
        if(arms.getType()!=null && !arms.getType().equals("")) {
            queryWrapper.eq("type", arms.getType());
        }
        queryWrapper.orderByDesc("id");
        Page<Arms> page1 = armsService.page(page,queryWrapper);
        return Response.success(page1);
    }

    @RequestMapping(value = "selectArms", method = RequestMethod.POST)
    @ApiOperation(value = "根据条件获取武器", notes = "", httpMethod = "POST")
    public Response selectArms(@RequestBody BoxArmsSeachDto boxArmsSeachDto) {

        List<Arms> list = armsService.selectArms(boxArmsSeachDto);
        return Response.success(list);
    }

    @RequestMapping(value = "addInfo", method = RequestMethod.POST)
    @ApiOperation(value = "添加武器", notes = "", httpMethod = "POST")
    public Response addInfo(@RequestBody AddArmsDto dto,  HttpServletRequest request) {
        CurrentUser currentUser = currentUser();
        if (currentUser == null) {
            return Response.fail(ErrorEnum.SIGN_VERIFI_EXPIRE);
        }
      //  operationRecordService.addOperationRecord(new OperationRecord(dto.getMangerId(),"添加武器",dto.getName()+"武器","/arms/addInfo",0,client.getAddress(request.getRemoteAddr())));
        dto.setCreDate(new Date());
        Arms arms = BeanUtils.copyProperties(dto, Arms.class);
        if (!armsService.save(arms)) {
            return Response.fail(ErrorEnum.ERROR_SERVER);
        }
        return Response.success(arms);
    }

    @RequestMapping(value = "romveArms", method = RequestMethod.POST)
    @ApiOperation(value = "删除武器", notes = "", httpMethod = "POST")
    public Response romveArms(@RequestBody String id,  HttpServletRequest request) {
        CurrentUser currentUser = currentUser();
        if (currentUser == null) {
            return Response.fail(ErrorEnum.SIGN_VERIFI_EXPIRE);
        }
   //     operationRecordService.addOperationRecord(new OperationRecord(1,"删除武器","删除id为"+id+"的武器","/arms/romveArms",0,client.getAddress(request.getRemoteAddr())));

        JSONObject jsonObject = JSONObject.parseObject(id);
        if (!armsService.removeById(Long.parseLong(jsonObject.getString("id")))) {
            return Response.fail(ErrorEnum.ERROR_SERVER);
        }
        return Response.success();
    }

    @RequestMapping(value = "updateById", method = RequestMethod.POST)
    @ApiOperation(value = "修改武器信息", notes = "", httpMethod = "POST")
    public Response updateById(@RequestBody AddArmsDto dto,  HttpServletRequest request) {
        CurrentUser currentUser = currentUser();
        if (currentUser == null) {
            return Response.fail(ErrorEnum.SIGN_VERIFI_EXPIRE);
        }

       // operationRecordService.addOperationRecord(new OperationRecord(dto.getMangerId(),"修改武器",dto.getName()+"的武器","/arms/updateById",0,client.getAddress(request.getRemoteAddr())));

        Arms arms = BeanUtils.copyProperties(dto, Arms.class);
        if (!armsService.updateById(arms)) {
            return Response.fail(ErrorEnum.ERROR_SERVER);
        }
        return Response.success(arms);
    }

    @RequestMapping(value = "updateAramStatus", method = RequestMethod.POST)
    @ApiOperation(value = "修改武器状态根据id", notes = "", httpMethod = "POST")
    public Response updateAramStatus(String id, String isStatus,  HttpServletRequest request) {
        CurrentUser currentUser = currentUser();
        if (currentUser == null) {
            return Response.fail(ErrorEnum.SIGN_VERIFI_EXPIRE);
        }
        Arms arms = new Arms();

        arms.setId(Integer.parseInt(id));
        arms.setIsStatus(Integer.parseInt(isStatus));
        if (!armsService.updateById(arms)) {
            return Response.fail(ErrorEnum.ERROR_SERVER);
        }
        return Response.success();
    }


    @RequestMapping(value = "addListArms", method = RequestMethod.GET)
    @ApiOperation(value = "导入武器", notes = "", httpMethod = "GET")
    public Response addListArms(Double percentage ,Integer page) {
        /*CurrentUser currentUser = currentUser();
        if(currentUser==null){
            return Response.fail(ErrorEnum.SIGN_VERIFI_EXPIRE);
        }*/
        System.out.println("=======");
        Map<String, String> param1 = new HashMap<>();
        param1.put("app-key","0b791fef5d1cc463edda79924704e8a7");
        param1.put("language","zh_CN");
        param1.put("appId","730");
        param1.put("limit","100");
        param1.put("page",1+"");
        String json1 = client.httpGetWithJSon("https://app.zbt.com/open/product/v2/search", param1);
        System.out.println("=======");
        Object succesResponse3 = JSON.parse(json1);
        System.out.println("=======");//先转换成Object
        System.out.println(json1);
        Map map5 = (Map) succesResponse3;         //Object强转换为Map
        if(!(boolean) map5.get("success")){
            return Response.fail(map5.get("errorMsg")+"");
        }
        Object succesResponse4 = JSON.parse(map5.get("data") + "");
        Map map6 = (Map) succesResponse4;
        int j=(int) map6.get("pages");

        for (int i = 0; i <j ; i++) {
            System.out.println("=======");
            Map<String, String> param = new HashMap<>();
            param.put("app-key","0b791fef5d1cc463edda79924704e8a7");
            param.put("language","zh_CN");
            param.put("appId","730");
            param.put("limit","100");
            param.put("page",i+1+"");
            String json = client.httpGetWithJSon("https://app.zbt.com/open/product/v2/search", param);

            System.out.println("=======");
            Object succesResponse = JSON.parse(json);
            System.out.println("=======");//先转换成Object
            System.out.println(json);
            Map map = (Map) succesResponse;//Object强转换为Map

            if(!(boolean) map.get("success")){
                return Response.fail(map.get("errorMsg")+"");
            }
            Object succesResponse1 = JSON.parse(map.get("data") + "");
            Map map1 = (Map) succesResponse1;
            List amList = new ArrayList();
            List list = (List) map1.get("list");
            for (Object o : list) {
                Map map2 = (Map) o;
                Arms arms = new Arms();
                if(map2.get("rarityName")!=null&&map2.get("rarityName").equals("消费级")){
                    arms.setType("1");
                }

                if(map2.get("rarityName")!=null&&map2.get("rarityName").equals("工业级")){
                    arms.setType("2");
                }

                if(map2.get("rarityName")!=null&&map2.get("rarityName").equals("军规级")){
                    arms.setType("3");
                }
                if(map2.get("rarityName")!=null&&map2.get("rarityName").equals("受限")){
                    arms.setType("4");
                }
                if(map2.get("rarityName")!=null&&map2.get("rarityName").equals("保密")){
                    arms.setType("5");
                }
                if(map2.get("rarityName")!=null&&map2.get("rarityName").equals("隐秘")){
                    arms.setType("6");
                }
                if(map2.get("rarityName")!=null&&map2.get("rarityName").equals("大师")){
                    arms.setType("7");
                }
                arms.setCount((Integer) map2.get("quantity"));
                arms.setImageUrl(map2.get("imageUrl") + "");
                arms.setName(map2.get("itemName") + "");

                BigDecimal bigDecimal=new BigDecimal(1 );
                bigDecimal=bigDecimal.add(new BigDecimal(percentage));
                Object succesResponse2 = JSON.parse(map2.get("priceInfo") + "");
                Map map3 = (Map) succesResponse2;
                if(map2.get("priceInfo")!=null){
                    if(map3.get("price")!=null){
                        arms.setPrice(new BigDecimal(map3.get("price") + "").multiply(bigDecimal));
                        arms.setCount(Integer.valueOf(map3.get("autoDeliverQuantity")+""));
                    }
                }
                arms.setProductId(Integer.valueOf(map2.get("itemId")+""));

                amList.add(arms);
            }
            armsService.addListArms(amList);
        }

        return Response.success();
    }


    @RequestMapping(value = "updateListArms", method = RequestMethod.GET)
    @ApiOperation(value = "更新价格", notes = "", httpMethod = "GET")
    public Response updateListArms(Double percentage ,Integer page) {

        System.out.println("=======");
        Map<String, String> param1 = new HashMap<>();
        param1.put("app-key","0b791fef5d1cc463edda79924704e8a7");
        param1.put("language","zh_CN");
        param1.put("appId","730");
        param1.put("limit","100");
        param1.put("page",1+"");
        String json1 = client.httpGetWithJSon("https://app.zbt.com/open/product/v2/search", param1);
        System.out.println("=======");
        Object succesResponse3 = JSON.parse(json1);
        System.out.println("=======");//先转换成Object
        System.out.println(json1);
        Map map5 = (Map) succesResponse3;         //Object强转换为Map
        if(!(boolean) map5.get("success")){
            return Response.fail(map5.get("errorMsg")+"");
        }
        Object succesResponse4 = JSON.parse(map5.get("data") + "");
        Map map6 = (Map) succesResponse4;
        int j=(int) map6.get("pages");

        for (int i = 0; i <j; i++) {
            System.out.println("=======");
            Map<String, String> param = new HashMap<>();
            param.put("app-key","0b791fef5d1cc463edda79924704e8a7");
            param.put("language","zh_CN");
            param.put("appId","730");
            param.put("limit","100");
            param.put("page",i+1+"");
            String json = client.httpGetWithJSon("https://app.zbt.com/open/product/v2/search", param);
            System.out.println("=======");
            Object succesResponse = JSON.parse(json);
            System.out.println("=======");//先转换成Object
            System.out.println(json);
            Map map = (Map) succesResponse;         //Object强转换为Map
            if(!(boolean) map.get("success")){
                return Response.fail(map.get("errorMsg")+"");
            }
            Object succesResponse1 = JSON.parse(map.get("data") + "");
            Map map1 = (Map) succesResponse1;

            List amList = new ArrayList();
            List list = (List) map1.get("list");
            for (Object o : list) {
                Map map2 = (Map) o;
                Arms arms = new Arms();
                BigDecimal bigDecimal=new BigDecimal(1 );
                bigDecimal=bigDecimal.add(new BigDecimal(percentage));
                Object succesResponse2 = JSON.parse(map2.get("priceInfo") + "");
                Map map3 = (Map) succesResponse2;
                if(map2.get("priceInfo")!=null){
                    if(map3.get("price")!=null){
                        arms.setPrice(new BigDecimal(map3.get("price") + "").multiply(bigDecimal));
                    }
                }
                arms.setProductId(Integer.valueOf(map2.get("itemId")+""));

                amList.add(arms);
            }
            armsService.updateArms(amList);
        }




        return Response.success();
    }

}

