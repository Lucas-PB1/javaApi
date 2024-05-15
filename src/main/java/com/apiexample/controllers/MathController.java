package com.apiexample.controllers;

import com.apiexample.helpers.Numbers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("operation/")
public class MathController {

    @RequestMapping(value="/{type}/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double operation(
            @PathVariable("type") String type,
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!Numbers.isNumeric(numberOne) || !Numbers.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Not a valid number");
        }

        return switch (type) {
            case "sum" -> Numbers.convertToDouble(numberOne) + Numbers.convertToDouble(numberTwo);
            case "sub" -> Numbers.convertToDouble(numberOne) - Numbers.convertToDouble(numberTwo);
            case "multi" -> Numbers.convertToDouble(numberOne) * Numbers.convertToDouble(numberTwo);
            case "div" -> Numbers.convertToDouble(numberOne) / Numbers.convertToDouble(numberTwo);
            case "media" -> (Numbers.convertToDouble(numberOne) + Numbers.convertToDouble(numberTwo)) / 2;
            case "raiz" -> Math.sqrt(Numbers.convertToDouble(numberOne) + Numbers.convertToDouble(numberTwo));
            default -> 0d;
        };
    }
}
