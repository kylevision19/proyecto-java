package Model;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductosValidaciones implements Validator{
    
    @Override
    public boolean supports(Class<?> type){
        
        return Productos.class.isAssignableFrom(type);
        
    }
    
    @Override
    public void validate(Object o, Errors errors){
        
        Productos productos=(Productos)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "precio", "required.precio", "el campo precio es obligatorio. ");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre", "el campo nombre es obligatorio. ");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "required.descripcion", "el campo descripcion es obligatorio. ");
        
    }
    
}
