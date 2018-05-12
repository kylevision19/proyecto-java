package Controller;

import Model.Conectar;
import Model.Productos;
import Model.ProductosValidaciones;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping

public class AddController {
    
    ProductosValidaciones productosValidaciones;
    private JdbcTemplate jdbcTemplate;
    
    public AddController(){
        
        this.productosValidaciones=new ProductosValidaciones();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar()); 
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(){
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("add");
        mav.addObject("productos", new Productos());
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
            (
                    
                    @ModelAttribute("productos") Productos u,
                    BindingResult result,
                    SessionStatus status
                    
            )
    {
           this.productosValidaciones.validate(u, result);
           if(result.hasErrors())
           {
               ModelAndView mav=new ModelAndView();
               mav.setViewName("add");
               mav.addObject("productos", new Productos());
               return mav;
           }else
           {
               this.jdbcTemplate.update
               (
                     "insert into producto (precio,nombre,descripcion) values (?,?,?)",
                       u.getPrecio(),u.getNombre(),u.getDescripcion());
                     return new ModelAndView("redirect:/producto.htm"); 
           }        
    }
}
