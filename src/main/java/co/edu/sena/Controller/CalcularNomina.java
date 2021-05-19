/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.sena.Model.connection.beans.Nomina;
import co.edu.sena.Model.connection.dao.NominaDAO;

/**
 *
 * @author 57313
 */
@WebServlet(name = "CalcularNomina", urlPatterns = {"/CalcularNomina"})
public class CalcularNomina extends HttpServlet {

    Nomina td = new Nomina();
    NominaDAO tddao = new NominaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recibir los datos que viene de la vista
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String numDoc = request.getParameter("txtNumDoc");
        byte diasTrabajados = Byte.parseByte(request.getParameter("txtDiasTrabajados"));
        float sueldo = Float.parseFloat(request.getParameter("txtSueldo"));
        float salario, salud, pension, totalDevengado, totalDescuentos, valorNeto;
        float aTransporte = 106454;
        String accion = request.getParameter("accion");

        //realizar los calculos y enviar a la vista
        //realizar los calculos
        salario = ((sueldo / 30) * diasTrabajados);
        totalDevengado = (salario + aTransporte);
        //descuentos
        salud = (float) ((totalDevengado - aTransporte) * 0.04);
        pension = (float) ((totalDevengado - aTransporte) * 0.04);
        totalDescuentos = (salud + pension);

        //valor neto
        valorNeto = (totalDevengado - totalDescuentos);

        //arrayList
        List<String> listado = new ArrayList<String>();
        listado.add(nombre);
        listado.add(apellido);
        listado.add(numDoc);
        listado.add(Byte.toString(diasTrabajados));
        listado.add(Float.toString(salario));
        listado.add(Float.toString(aTransporte));
        listado.add(Float.toString(totalDevengado));
        listado.add(Float.toString(salud));
        listado.add(Float.toString(pension));
        listado.add(Float.toString(totalDescuentos));
        listado.add(Float.toString(valorNeto));

        
        
        if (accion.equals("Listar")) {
            List listar = tddao.Listar();
            request.setAttribute("nomina", listar);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        if (accion.equals("Guardar")) {
            td.setNombre(nombre);
            td.setApellido(apellido);
            td.setNumDoc(numDoc);
            td.setDiasTrabajados(diasTrabajados);
            td.setSueldo(sueldo);
            
            tddao.Registrar(td);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
