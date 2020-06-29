/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wdym;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jeanwahlung
 */
public class WDYMSI {

    //Regex dd
    private static String REGEX1 = "[dsfecrwxr][dsfecxvewr]";
    //Regex vi
    private static String REGEX2 = "[vcbfg][iolkju]";
    // Regex wget  
    private static String REGEX3 = "[wqasde][ghtbvyr][ewrfds][tryhgf]";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, URISyntaxException {
        Boolean resp2 = true;

        while (resp2) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese El Commando");

            String comando = sc.nextLine();
            Pattern p = Pattern.compile(REGEX1);
            if (comando.matches(REGEX1)) {
                ArrayList<String> existentes = new ArrayList();
                File archivo = null;
                FileReader fr = null;
                BufferedReader br = null;

                try {

                    archivo = new File("src/wdym/Listacomandosdd.txt");
                    fr = new FileReader(archivo);
                    br = new BufferedReader(fr);

                    // Lectura del fichero
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        existentes.add(linea);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    try {
                        if (null != fr) {
                            fr.close();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }

                }

                boolean flag = false;

                for (int i = 0; i < existentes.size(); i++) {
                    if (comando.equals(existentes.get(i))) {
                        flag = true;
                    }
                }
                if (comando.equals("dd")) {
                    System.out.println("esta en la lista de comandos");
                    String command = "cmd /c start cmd.exe";
                    Process child = Runtime.getRuntime().exec(command);
                } else if (flag) {
                    System.out.println("esta en la lista de comandos");
                    String command = "cmd /c start cmd.exe";
                    Process child = Runtime.getRuntime().exec(command);

                    OutputStream out = child.getOutputStream();
                } else {
                    System.out.println("Quiso decir \"dd\" ? S/N: ");
                    String resp = sc.nextLine();

                    if (resp.equalsIgnoreCase("s")) {

                        String palabras = "";
                        for (int i = 0; i < existentes.size(); i++) {
                            palabras += existentes.get(i) + "\n";
                        }
                        palabras += comando;
                        FileWriter fichero = null;
                        PrintWriter pw = null;
                        try {
                            fichero = new FileWriter("src/wdym/Listacomandosdd.txt");
                            pw = new PrintWriter(fichero);

                            pw.println(palabras);

                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {

                                if (null != fichero) {
                                    fichero.close();
                                }
                            } catch (IOException e2) {
                            }
                        }
                        System.out.println("esta en la lista de comandos");
                        String command = "cmd /c start cmd.exe";
                        Process child = Runtime.getRuntime().exec(command);

                    }
                }

            } else if (comando.matches(REGEX2)) {
                ArrayList<String> existentes = new ArrayList();
                File archivo = null;
                FileReader fr = null;
                BufferedReader br = null;

                try {
                    // Apertura del fichero y creacion de BufferedReader para poder
                    // hacer una lectura comoda (disponer del metodo readLine()).
                    archivo = new File("src/wdym/Listacomandosvi.txt");
                    fr = new FileReader(archivo);
                    br = new BufferedReader(fr);

                    // Lectura del fichero
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        existentes.add(linea);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // En el finally cerramos el fichero, para asegurarnos
                    // que se cierra tanto si todo va bien como si salta 
                    // una excepcion.
                    try {
                        if (null != fr) {
                            fr.close();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

                boolean flag = false;

                for (int i = 0; i < existentes.size(); i++) {
                    if (comando.equals(existentes.get(i))) {
                        flag = true;
                    }
                }
                if (comando.equals("vi")) {
                    File f = new File("src/perrito.jpg");
                    Desktop dt = Desktop.getDesktop();
                    dt.open(f);
                    System.out.println("Ya se abrio su visor de imagen revise la barra de tareas.");
                } else if (flag) {
                    File f = new File("src/perrito.jpg");
                    Desktop dt = Desktop.getDesktop();
                    dt.open(f);
                    System.out.println("Ya se abrio su visor de imagen revise la barra de tareas.");
                } else {
                    System.out.println("Quiso decir \"vi\"? S/N: ");
                    String resp = sc.nextLine();
                    if (resp.equalsIgnoreCase("s")) {

                        String palabras = "";
                        for (int i = 0; i < existentes.size(); i++) {
                            palabras += existentes.get(i) + "\n";
                        }
                        palabras += comando;
                        FileWriter fichero = null;
                        PrintWriter pw = null;
                        try {
                            fichero = new FileWriter("src/wdym/Listacomandosvi.txt");
                            pw = new PrintWriter(fichero);

                            pw.println(palabras);

                        } catch (IOException e) {
                        } finally {
                            try {
                                // Nuevamente aprovechamos el finally para 
                                // asegurarnos que se cierra el fichero.
                                if (null != fichero) {
                                    fichero.close();
                                }
                            } catch (IOException e2) {
                            }
                        }

                        File f = new File("src/perrito.jpg");
                        Desktop dt = Desktop.getDesktop();
                        dt.open(f);
                        System.out.println("Ya se abrio su visor de imagen revise la barra de tareas.");
                    }
                }
            } else if (comando.matches(REGEX3)) {
                ArrayList<String> existentes = new ArrayList();
                File archivo = null;
                FileReader fr = null;
                BufferedReader br = null;

                try {
                    // Apertura del fichero y creacion de BufferedReader para poder
                    // hacer una lectura comoda (disponer del metodo readLine()).
                    archivo = new File("src/wdym/Listacomandoswget.txt");
                    fr = new FileReader(archivo);
                    br = new BufferedReader(fr);

                    // Lectura del fichero
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        existentes.add(linea);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // En el finally cerramos el fichero, para asegurarnos
                    // que se cierra tanto si todo va bien como si salta 
                    // una excepcion.
                    try {
                        if (null != fr) {
                            fr.close();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

                boolean flag = false;

                for (int i = 0; i < existentes.size(); i++) {
                    if (comando.equals(existentes.get(i))) {
                        flag = true;
                    }
                }
                if (comando.equals("wget")) {
                    if (java.awt.Desktop.isDesktopSupported()) {
                        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

                        if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                            try {
                                java.net.URI uri = new java.net.URI("https://www.google.com");
                                desktop.browse(uri);
                            } catch (IOException ex) {

                            }
                        }
                    }
                } else if (flag) {
                    if (java.awt.Desktop.isDesktopSupported()) {
                        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

                        if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                            try {
                                java.net.URI uri = new java.net.URI("https://www.google.com");
                                desktop.browse(uri);
                            } catch (IOException ex) {

                            }
                        }
                    }
                } else {
                    System.out.println("Quiso decir \"wget\"? S/N: ");
                    String resp = sc.nextLine();
                    if (resp.equalsIgnoreCase("s")) {

                        String palabras = "";
                        for (int i = 0; i < existentes.size(); i++) {
                            palabras += existentes.get(i) + "\n";
                        }
                        palabras += comando;

                        FileWriter fichero = null;
                        PrintWriter pw = null;
                        try {
                            fichero = new FileWriter("src/wdym/Listacomandoswget.txt");
                            pw = new PrintWriter(fichero);

                            pw.println(palabras);

                        } catch (IOException e) {
                        } finally {
                            try {
                                // Nuevamente aprovechamos el finally para 
                                // asegurarnos que se cierra el fichero.
                                if (null != fichero) {
                                    fichero.close();
                                }
                            } catch (IOException e2) {
                            }
                        }

                        if (java.awt.Desktop.isDesktopSupported()) {
                            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

                            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                                try {
                                    java.net.URI uri = new java.net.URI("https://www.google.com");
                                    desktop.browse(uri);
                                } catch (IOException ex) {

                                }
                            }
                        }

                    }
                }

            } else {
                System.out.println("commando no existe ");
            }
            System.out.println("Desea Meter otro comando? S/N");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("S")) {

            } else {
                resp2 = false;
            }
        }
    }
}
