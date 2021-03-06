/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.view;

import br.com.model.controller.ConvenioController;
import br.com.model.paciente.Convenio;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ederson
 */
public class ConvenioListaGUI extends javax.swing.JFrame {

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public ConvenioListaGUI() {
        initComponents();
        criaJTable();
        PainelRolagem.setViewportView(tabela);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PainelSuperior = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PainelInferior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PainelRolagem = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        txPesquisar = new javax.swing.JTextField();
        btInserir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        PainelSuperior.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setText("Convenio");

        javax.swing.GroupLayout PainelSuperiorLayout = new javax.swing.GroupLayout(PainelSuperior);
        PainelSuperior.setLayout(PainelSuperiorLayout);
        PainelSuperiorLayout.setHorizontalGroup(
            PainelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelSuperiorLayout.setVerticalGroup(
            PainelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        PainelInferior.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/model/images/Java.png"))); // NOI18N

        javax.swing.GroupLayout PainelInferiorLayout = new javax.swing.GroupLayout(PainelInferior);
        PainelInferior.setLayout(PainelInferiorLayout);
        PainelInferiorLayout.setHorizontalGroup(
            PainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelInferiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        PainelInferiorLayout.setVerticalGroup(
            PainelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelInferiorLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setText("Pesquisar.:");

        txPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesquisarActionPerformed(evt);
            }
        });

        btInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/model/images/Mais32.png"))); // NOI18N
        btInserir.setText("Inserir");
        btInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btInserir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/model/images/Edit32.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/model/images/Delete32.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btOk.setText("Ok");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PainelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PainelRolagem, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btOk))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btInserir)
                        .addGap(18, 18, 18)
                        .addComponent(btEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(PainelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btEditar)
                                .addComponent(btInserir, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(btExcluir)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btOk)))
                .addGap(18, 18, 18)
                .addComponent(PainelRolagem, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PainelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        ConvenioInserirGUI fi = new ConvenioInserirGUI(modelo);
        fi.setLocationRelativeTo(this);
        fi.setTitle("Inserir Convênio[EMJ]");
        fi.setVisible(true);
    }//GEN-LAST:event_btInserirActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int i = (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse convênio permanentemente?", "Excluir funcionário", JOptionPane.YES_NO_OPTION));
            if (i == 0) {
                try {
                int idPaciente = (int) tabela.getValueAt(linhaSelecionada, 0);
                ConvenioController pc = new ConvenioController();
                if (pc.remove(idPaciente)) {
                    modelo.removeRow(linhaSelecionada);
                } else {
                    JOptionPane.showMessageDialog(this, "Nehuma linha foi selecionada.");
                }
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir: "+e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão Cancelada");
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idConvenio = (int) tabela.getValueAt(linhaSelecionada, 0);
            ConvenioInserirGUI fi = new ConvenioInserirGUI(modelo, linhaSelecionada, idConvenio);
            fi.setLocationRelativeTo(this);
            fi.setTitle("Editar Convênio[EMJ]");
            fi.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nehuma linha foi selecionada.");
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void txPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesquisarActionPerformed
        String nome = txPesquisar.getText();
        ConvenioController fc
                = new ConvenioController();
        modelo.setNumRows(0);
        for (Convenio f : fc.listByNome(nome)) {
            modelo.addRow(new Object[]{
                f.getCodigo(), f.getNome()
            });
        }
    }//GEN-LAST:event_txPesquisarActionPerformed

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        String nome = txPesquisar.getText();
        ConvenioController fc = new ConvenioController();
        modelo.setNumRows(0);

        for (Convenio f : fc.listByNome(nome)) {
            modelo.addRow(new Object[]{
                f.getCodigo(), f.getNome()
            });
        }

        txPesquisar.grabFocus();
    }//GEN-LAST:event_btOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelInferior;
    private javax.swing.JScrollPane PainelRolagem;
    private javax.swing.JPanel PainelSuperior;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txPesquisar;
    // End of variables declaration//GEN-END:variables

    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        preencherJTable();
    }

    private void preencherJTable() {
        ConvenioController uc = new ConvenioController();
        for (Convenio f : uc.listarTodos()) {
            modelo.addRow(new Object[]{
                f.getCodigo(), f.getNome()
            });
        }
    }
}
