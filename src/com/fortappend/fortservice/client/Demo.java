package com.fortappend.fortservice.client;

import com.fortappend.fortservice.client.vo.BaseResourceVo;
import com.fortappend.fortservice.client.vo.FlagEnum;
import com.fortappend.fortservice.client.vo.ItilResourceVo;
import com.fortappend.fortservice.client.vo.ReadAuthorizationRequestVo;
import com.fortappend.fortservice.client.vo.ReadAuthorizationResponseVo;
import com.fortappend.fortservice.client.vo.WriteItilAuthorizationRequestVo;
import com.fortappend.fortservice.client.vo.WriteItilAuthorizationResponseVo;

public class Demo {
    
    public static void main(String[] args) throws Exception{
        
        //配置堡垒机IP地址(必须)
        FortServiceClient.config("192.168.10.129");
        
        //读堡垒机授权DEMO
        ReadAuthorizationRequestVo request1 = new ReadAuthorizationRequestVo();
        request1.setPersonAccount("zhangke");
        request1.setFortEnv("true");
        ReadAuthorizationResponseVo response1 = FortServiceClient.readAuthorization(request1);
        if(FlagEnum.SUCCESS.getName().equals(response1.getFlag())){
            for(BaseResourceVo vo : response1.getResultSet()){
                System.out.println(vo.getPersonAccount());
                System.out.println(vo.getResourceIp());
                System.out.println(vo.getResourceAccount());
            }
        }else if(FlagEnum.FAIL.getName().equals(response1.getFlag())){
            System.out.println("从堡垒读取授权失败");
        }else if(FlagEnum.NO_AUTHORIZATION.getName().equals(response1.getFlag())){
            System.out.println("该用户无授权");
        }else if(FlagEnum.PERSON_NOT_EXISTS.getName().equals(response1.getFlag())){
            System.out.println("用户不存在");
        }
        
        //写Itil授权DEMO
        ItilResourceVo itilResourceVo = new ItilResourceVo();
        itilResourceVo.setPersonAccount("zhangke");
        itilResourceVo.setResourceIp("1.2.3.4");
        itilResourceVo.setResourceAccount("root");
        itilResourceVo.setStartDatetime("2015-09-19 14:00:00");
        itilResourceVo.setEndDatetime("2015-09-19 14:00:00");
        ItilResourceVo[] dataSet = new ItilResourceVo[1];
        dataSet[0] = itilResourceVo;
        WriteItilAuthorizationRequestVo request2 = new WriteItilAuthorizationRequestVo();
        request2.setDataSet(dataSet);
        WriteItilAuthorizationResponseVo response2 = FortServiceClient.writeItilAuthorization(request2);
        if(FlagEnum.SUCCESS.getName().equals(response2.getFlag())){
            System.out.println("向堡垒写授权成功");
        }else{
            System.out.println("向堡垒写授权失败");
        }
    }
}
