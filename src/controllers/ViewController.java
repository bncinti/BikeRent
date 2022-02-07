package controllers;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.BikeModel;
import models.ViewModel;
import views.BikeForm;


public class ViewController {
    
    private BikeForm bikeFrm;
    private ViewModel viewMdl;
    private BikeModel bikeMdl;
    private Vector<Vector<Object>> tableData;
    private DataBaseController dbCtr;

    public ViewController( DataBaseController dbCtr) {
        
        this.dbCtr = dbCtr;
        bikeFrm = new BikeForm();
        viewMdl = new ViewModel();
        initComponents();
        initListeners();
        start();
    }
    
    private void initComponents() {
        if (dbCtr.setDatabase()){
            bikeFrm.setStatusLbl("Kapcsolat OK");
          }
        
    }
    
    private void initListeners() {
        
        bikeFrm.getExitBtn().addActionListener( event -> { exit(); });
        bikeFrm.getDeleteBtn().addActionListener( event -> { delete(); });
        bikeFrm.getEditBtn().addActionListener( event -> { edit(); });
        bikeFrm.getSaveBtn().addActionListener( event -> { save(); });
        bikeFrm.getSearchBtn().addActionListener( event -> { search(); });
        bikeFrm.getTableTb().addChangeListener(event-> {initTables(); });
    }
    
    private void start() {
        initTables();       
        bikeFrm.setVisible( true );
    }
    
    private void initTables(){
        Vector<String> columnNames = new Vector<>();
        tableData = new Vector<>();
        
        if(bikeFrm.getTableTb().getSelectedIndex() ==0){
           
            columnNames = viewMdl.getMemberColumnNames();
            tableData = dbCtr.getMembers();
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            bikeFrm.getMemberTbl().setModel( tablMdl );
            
           
            
        }else if(bikeFrm.getTableTb().getSelectedIndex()==1){
            
            columnNames = viewMdl.getBikeColumnNames();
             TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            bikeFrm.getBikeTbl().setModel( tablMdl );
            
        
        }else{
            
            columnNames = viewMdl.getRentColumnNames();
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            bikeFrm.getRentTbl().setModel( tablMdl );
            
        }
    }
    
    private void setTablesData(Vector<Vector<Object>> tableData, Vector<String> columnNames){
        TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
        bikeFrm.getMemberTbl().setModel( tablMdl );
    }
    
    private void search() {

    }
    
    private void save() {
        
    }

    private void edit() {
        
    }
    
    private void delete() {
        
    }
    
    private void exit() {
        
        System.exit( 0 );
    }
}