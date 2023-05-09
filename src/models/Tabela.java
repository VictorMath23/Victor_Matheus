/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vsilva18
 */
public class Tabela extends AbstractTableModel{

   
    private List<Produto> dados_produto = new ArrayList<>();
    private String[] colunas = { "id", "nome", "valor", "status"};
    
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }        
            
            
    @Override
    public int getRowCount() {
        return dados_produto.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
       
        switch(coluna){
            case 0:
                return dados_produto.get(linha).getId();
            case 1:
                return dados_produto.get(linha).getNome();
            case 2:
                return dados_produto.get(linha).getValor();
            case 3:
                return dados_produto.get(linha).getStatus();
            
        }
            return null;
    }
    
    public void addRow(Produto pt){
        this.dados_produto.add(pt);
        fireTableDataChanged();
        fireTableStructureChanged();
    }
    
    public void removeRow(int linha){
        
        this.dados_produto.remove(linha);
        fireTableDataChanged();
        
    }
    public void removeDados(){
        
        this.dados_produto.clear();
        fireTableDataChanged();
    
    }
    
    public void atualizaDados(){
        
    }
    
    public void preencheTabela(List<Produto> produtos){
        this.dados_produto = produtos;
        fireTableDataChanged();
    }
}

