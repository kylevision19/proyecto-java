package Controller;

import Model.Conectar;
import Model.Productos;
import Model.ProductosValidaciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("edit.htm")

public class EditController {
    
    ProductosValidaciones productosValidaciones;
    private JdbcTemplate jdbcTemplate;
    
    public EditController(){
        
        this.productosValidaciones=new ProductosValidaciones();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
        
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        int cod_producto=Integer.parseInt(request.getParameter("cod_producto"));
        Productos datos=this.selectProducto(cod_producto);
        mav.setViewName("edit");
        mav.addObject("productos", new Productos(cod_producto,datos.getPrecio(),datos.getNombre(),datos.getDescripcion()));
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                
                @ModelAttribute("productos") Productos u,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
                
        )
        {
            this.productosValidaciones.validate(u, result);
            if(result.hasErrors())
            {
                
                ModelAndView mav=new ModelAndView();
                int cod_producto=Integer.parseInt(request.getParameter("cod_producto"));
                Productos datos=this.selectProducto(cod_producto);
                mav.setViewName("edit");
                mav.addObject("productos", new Productos(cod_producto,datos.getPrecio(),datos.getNombre(),datos.getDescripcion()));
                return mav;
            }else
            {
                  int cod_producto=Integer.parseInt(request.getParameter("cod_producto"));
                  this.jdbcTemplate.update
                  (
                          "update producto"
                        +" set precio=?,"
                        +" nombre=?,"
                        +" descripcion=?"
                        +" where"
                        +" cod_producto=?",
                        u.getPrecio(),u.getNombre(),u.getDescripcion(),cod_producto);
                  return new ModelAndView("redirect:/producto.htm");
            }
        }

    private Productos selectProducto(int cod_producto) {
        
        final Productos product=new Productos();
        String quer="SELECT * FROM producto WHERE cod_producto='"+cod_producto+"'";
        return (Productos) jdbcTemplate.query(quer, new ResultSetExtractor<Productos>() {
            public Productos extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    //product.setCod_producto(rs.getInt("cod_producto"));
                    product.setPrecio(rs.getInt("precio"));
                    product.setNombre(rs.getString("nombre"));
                    product.setDescripcion(rs.getString("descripcion"));
                }
                
                return product;
                
            }
        });
        
    }

    
    
}
