package com.Comandos;

import com.Entidades.Nodo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Universidad Catolica Andres Bello
 * Facultad de Ingenieria
 * Escuela de Ingenieria Informatica
 * Trabajo Especial de Grado
 * ----------------------------------
 * Tutor:
 * --------------
 * Wilmer Pereira
 *
 * Autores:
 * --------------
 * Garry Bruno
 * Carlos Valero
 */
public class RecibirMensajeCommand extends AsyncCommand{

    public static final String COMMAND_NAME = "listen";


    @Override
    public String obtenerNombreComando() {
        return COMMAND_NAME;
    }

    @Override
    public void executeOnBackground(String[] args, OutputStream out) {
            try {
                Nodo nodo = Nodo.obtenerInstancia();
                ServerSocket recepcion = new ServerSocket(nodo.getPuertopeticion());
                while (true) {
                    System.out.printf("Conexion habilitada y en espera...");
                    Socket recibo = recepcion.accept();
                    ObjectInputStream ois = new ObjectInputStream(recibo.getInputStream());
                    ObjectOutputStream salidaObjeto = new ObjectOutputStream(recibo.getOutputStream());
                    //Mensaje que llega:
                    Object mensaje = ois.readObject();
                    //Falta ejecutar acciones dependiendo del mensaje
                    System.out.println("LLego: "+ (String) mensaje

                    );

                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Object respuesta = null;
    }

}