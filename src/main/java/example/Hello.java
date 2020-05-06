package example;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;

import java.util.LinkedHashMap;

public class Hello implements RequestHandler<Object, ResponseClass> {

    @Override
    public ResponseClass handleRequest(Object s, Context context) {
        LambdaLogger logger = context.getLogger();

        LinkedHashMap<String,Object> aaa = (LinkedHashMap) s;

        logger.log("s to String: " + aaa.toString());

        ResponseClass responseClass = new ResponseClass();
        responseClass.setGreetings(aaa.toString());
        return responseClass;
    }
}
