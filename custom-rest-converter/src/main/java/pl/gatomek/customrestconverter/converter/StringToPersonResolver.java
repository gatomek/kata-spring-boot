package pl.gatomek.customrestconverter.converter;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import pl.gatomek.customrestconverter.model.Person;
import pl.gatomek.customrestconverter.model.Sex;

public class StringToPersonResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Person.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String name = webRequest.getParameter("name");
        String ageStr = webRequest.getParameter("age");
        String sexStr = webRequest.getParameter("sex");

        int age = Integer.parseInt(ageStr);
        Sex sex = Sex.fromDesc(sexStr);

        return Person.of(name, age, sex);
    }
}
