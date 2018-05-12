package Controller;

import Model.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ProductoController {
    
    private JdbcTemplate jdbcTemplate;
    
    public ProductoController(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("producto.htm")
    public ModelAndView producto(){
        
        ModelAndView mav=new ModelAndView();
        String sql="select * from producto";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("producto");
        
        return mav;
        
    }
    
}
