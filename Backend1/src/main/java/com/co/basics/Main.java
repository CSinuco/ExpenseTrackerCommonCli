package com.co.basics;


import org.apache.commons.cli.*;

import java.io.PrintWriter;

public class Main {
    public static final Option ARG_ADD = new Option("a", "add", false, "add an expense to the user" );
    public static final Option ARG_SHOWALL = new Option("b", "showAll", true, "show all expense from the user" );
    public static final Option ARG_DELETE = new Option("c", "delete", false, "delete an expense to the user" );
    public static final Option ARG_SUMMARY = new Option("d", "summary", false, "summary of the expenses" );

    private static void  printHelp(Options options){
        HelpFormatter formatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("Expense tracker");
        printWriter.println();
        formatter.printOptions(printWriter, 100, options, 2, 2);
        printWriter.close();

    }
    public static void main(String[] args) {
        User usuario = new User();

        CommandLineParser clp = new DefaultParser();
        Options options = new Options();
        options.addOption(ARG_ADD);
        options.addOption(ARG_SHOWALL);
        options.addOption(ARG_DELETE);
        options.addOption(ARG_SUMMARY);
        int valor = 0;
        String description = "";
        int id = 0;
        try{
           CommandLine cl =  clp.parse(options, args);
           if(cl.getArgList().size() < 2){
               printHelp(options);
               System.exit(-1);
           }

           if(cl.hasOption(ARG_ADD.getLongOpt())){
               try{
                   valor = Integer.parseInt(cl.getArgList().get(0));
                   description = cl.getArgList().get(1);
               }
               catch (Exception e){
                   e.printStackTrace();
               }
               usuario.addExpense(description, valor);
           } else if (cl.hasOption(ARG_SHOWALL.getLongOpt())) {
               usuario.mostrarExpenses();

           }else if (cl.hasOption(ARG_DELETE.getLongOpt())) {
               try{
                   id = Integer.parseInt(cl.getArgList().get(0));
               }catch (Exception e){
                   System.out.println("Id no encontrado");
               }
                usuario.deleteExpenses(id);
           }else if (cl.hasOption(ARG_SUMMARY.getLongOpt())) {
               usuario.getSummaryExpenses();
           }
        }catch (Exception e){
            e.printStackTrace();
        }




    }
}