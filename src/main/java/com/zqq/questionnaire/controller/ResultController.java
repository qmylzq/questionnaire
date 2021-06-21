package com.zqq.questionnaire.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ author: 曲梦瑶
 * @ date: 2020/3/9-19 : 38
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/answer")
@Api(value ="/test" ,tags={"自动API"})
public class ResultController {

    @ApiOperation(value ="eolinker自动生成API测试")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "参数1",value = "参数1的值",dataType = "String")
    )
    @ApiResponses(
            @ApiResponse(code = 200,message = "测试成功")
    )
    public String apiTest(){
        return "This is a test!";
    }
}
