package Controller;

import Model.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class DeleteController {
    
    private JdbcTemplate jdbcTemplate;
    public DeleteController(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
        
    }
    
    @RequestMapping("delete.htm")
    public ModelAndView producto(HttpServletRequest request){
        
        int cod_producto=Integer.parseInt(request.getParameter("cod_producto"));
        this.jdbcTemplate.update
        (
        "delete from producto"
        +" where"
        +" cod_producto=?",cod_producto);
        return new ModelAndView("redirect:/producto.htm");
    }
    
}
