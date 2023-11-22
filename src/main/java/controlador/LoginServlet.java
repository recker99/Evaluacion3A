package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.LoginDAO;

//import modelo.Persona;
import modelo.Persona;
import modelo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/index")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 // En tu servlet o controlador
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos de la persona
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Persona persona = LoginDAO.obtenerDatosPersona(username, password);
        
        // Establecer los atributos en el objeto request
        request.setAttribute("persona", persona);
        
        // Redirigir a mensaje.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mensaje.jsp");
        dispatcher.forward(request, response);
    }


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	// TODO Auto-generated method stub
    		String usuario, password, msg="";
    		
    		// 1. recibir los parametros
    		usuario = request.getParameter("usuario");
    		password = request.getParameter("password");
    		
    		// 2. validar
    		try {
    			if(LoginDAO.validar(usuario, password)>0) {
    				msg = "Usuario y Contraseña correctos";
    			}else{
    				msg = "Revise su Usuario o Contraseña";
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		// 3. ejecute logica de negocio
    		msg = msg.toUpperCase();
    		
    		// 4. seleccionar proxima vista
    		RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");
    		
    		// 5. preparar los datos para vista seleccionada
    		request.setAttribute("mensaje", msg);
    		
    		// 6. despachar
    		despachador.forward(request, response);
    	}
}
    	

