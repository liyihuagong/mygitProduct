/**
 * 
 */
package demo.controllerAdvice;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.vo.TResult;

/**
 * @author liyi
 *
 */

@ControllerAdvice
public class RestApiControlAdvice {
 
    @ExceptionHandler(value=RuntimeException.class)
    @ResponseBody
    public String handle(RuntimeException e) {
        // *记入异常日志
        return e.getMessage();
    }
 
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public String handle(Exception e) {
        // *记入异常日志
        return e.getMessage();
 
    }
    
//    @ExceptionHandler(value=MissingServletRequestParameterException.class)
//    @ResponseBody
//    public String handle(MissingServletRequestParameterException e) {
//        return "Miss parameter " + e.getParameterName() + ":" + e.getParameterType();
//    }
//     
//    @ExceptionHandler(value= TypeMismatchException.class)
//    @ResponseBody
//    public String handle(TypeMismatchException e) {
//        return e.getErrorCode() + ", required type: " + e.getRequiredType() + ", but value: " + e.getValue();
//    }
// 
}
