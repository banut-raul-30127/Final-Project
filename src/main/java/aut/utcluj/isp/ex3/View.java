package aut.utcluj.isp.ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
     JButton buttonAdd, buttonRemove, buttonSearch, buttonEdit, buttonAll, buttonNumber;
     JFrame frame;
     JPanel panel;
    StockController ctrl = new StockController();

    public View() {
        frame = new JFrame("Catalogue ");
        panel = new JPanel();

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        buttonAdd = new JButton("Add");
        buttonRemove = new JButton("Remove");
        buttonSearch = new JButton("Search");
        buttonEdit = new JButton("Edit");
        buttonAll = new JButton("Show all");
        buttonNumber = new JButton("Number of products");

        buttonAdd.addActionListener(new MyActionListener());
        buttonRemove.addActionListener(new MyActionListener());
        buttonSearch.addActionListener(new MyActionListener());
        buttonEdit.addActionListener(new MyActionListener());
        buttonAll.addActionListener(new MyActionListener());
        buttonNumber.addActionListener(new MyActionListener());

        panel.setLayout(new GridLayout(3, 2));

        panel.add(buttonAdd);
        panel.add(buttonRemove);
        panel.add(buttonSearch);
        panel.add(buttonEdit);
        panel.add(buttonAll);
        panel.add(buttonNumber);

        frame.setContentPane(panel);
        frame.setSize(400, 400);

    }


    class MyActionListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonAdd) {

                JFrame newFrame = new JFrame("Add");
                JPanel secondPanel = new JPanel();
                newFrame.setVisible(true);

                newFrame.setContentPane(secondPanel);
                newFrame.setSize(400, 400);

                JLabel nameLabel = new JLabel("Product name:");
                JLabel idLabel = new JLabel("Product ID:");
                JLabel priceLabel = new JLabel("Product price: ");
                JLabel quantityLabel = new JLabel("Quantity: ");
                JButton okButton = new JButton("OK");

                JTextField nameText = new JTextField();
                JTextField idText = new JTextField();
                JTextField priceText = new JTextField();
                JTextField quantityText = new JTextField();

                secondPanel.setLayout(null);
                //labels
                nameLabel.setBounds(10, 20, 100, 20);
                idLabel.setBounds(10, 60, 100, 20);
                priceLabel.setBounds(10, 100, 100, 20);
                quantityLabel.setBounds(10, 140, 100, 20);
                okButton.setBounds(170, 180, 100, 20);

                //textFields
                nameText.setBounds(120, 20, 200, 20);
                idText.setBounds(120, 60, 200, 20);
                priceText.setBounds(120, 100, 200, 20);
                quantityText.setBounds(120, 140, 200, 20);

                //adding
                secondPanel.add(nameText);
                secondPanel.add(idText);
                secondPanel.add(priceText);
                secondPanel.add(nameLabel);
                secondPanel.add(idLabel);
                secondPanel.add(priceLabel);
                secondPanel.add(okButton);
                secondPanel.add(quantityLabel);
                secondPanel.add(quantityText);


                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Added");
                        Product p1 = new Product(idText.getText(), nameText.getText(), Double.parseDouble(priceText.getText()));
                        ctrl.addProductToCatalogue(p1, Integer.parseInt(quantityText.getText()));
                        newFrame.dispose();
                    }
                });


            }

            if (e.getSource() == buttonRemove) {
                JFrame newFrame = new JFrame("Remove");
                JPanel secondPanel = new JPanel();
                newFrame.setVisible(true);
                newFrame.setContentPane(secondPanel);
                newFrame.setSize(400, 400);
                secondPanel.setLayout(null);

                JLabel idLabel = new JLabel("Product ID:");
                JButton okButton = new JButton("OK");
                JTextField idText = new JTextField();

                idLabel.setBounds(10, 60, 100, 20);
                idText.setBounds(120, 60, 200, 20);
                okButton.setBounds(170, 100, 100, 20);

                secondPanel.add(idText);
                secondPanel.add(okButton);
                secondPanel.add(idLabel);

                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ctrl.removeAllProductsWitProductId(idText.getText());
                        newFrame.dispose();
                        System.out.println("Removed");
                    }
                });


            }

            //update the price by id
            if (e.getSource() == buttonEdit) {
                JFrame newFrame = new JFrame("Search");
                JPanel secondPanel = new JPanel();
                newFrame.setVisible(true);
                newFrame.setContentPane(secondPanel);
                newFrame.setSize(400, 250);
                secondPanel.setLayout(null);

                JLabel idLabel = new JLabel("Product ID :");
                JButton okButton = new JButton("OK ");
                JTextField idText = new JTextField();
                JLabel priceLabel = new JLabel("Product price: ");
                JTextField priceText = new JTextField();


                idLabel.setBounds(10, 60, 100, 20);
                priceLabel.setBounds(10, 100, 100, 20);
                idText.setBounds(120, 60, 200, 20);
                priceText.setBounds(120, 100, 200, 20);
                okButton.setBounds(170, 150, 100, 20);

                secondPanel.add(idText);
                secondPanel.add(okButton);
                secondPanel.add(idLabel);
                secondPanel.add(priceLabel);
                secondPanel.add(priceText);

                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Edited");
                        ctrl.updateProductPriceByProductId(idText.getText(), Double.parseDouble(priceText.getText()));
                        newFrame.dispose();
                    }
                });


            }

            // search by id
            if (e.getSource() == buttonSearch) {
                JFrame newFrame = new JFrame("Search");
                JPanel secondPanel = new JPanel();
                newFrame.setVisible(true);
                newFrame.setContentPane(secondPanel);
                newFrame.setSize(400, 400);
                secondPanel.setLayout(null);

                JLabel idLabel = new JLabel("Product ID :");
                JButton okButton = new JButton("OK ");
                JTextField idText = new JTextField();
                JTextArea result = new JTextArea();
                result.setBounds(10, 150, 360,200);
                idLabel.setBounds(10, 60, 100, 20);
                idText.setBounds(120, 60, 200, 20);
                okButton.setBounds(170, 100, 100, 20);

                secondPanel.add(result);
                secondPanel.add(idText);
                secondPanel.add(okButton);
                secondPanel.add(idLabel);

                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Search");
                         ctrl.getProductsWithSameId(idText.getText()) ;

                        //newFrame.dispose();
                    }
                });


            }

            //show all catalogue
            if (e.getSource() == buttonAll) {
                JFrame newFrame = new JFrame("All products");
                JPanel secondPanel = new JPanel();
                newFrame.setVisible(true);
                JLabel newLabel = new JLabel("The products: " + ctrl.getCatalogue());
                JButton okButton = new JButton("OK ");
                okButton.setBounds(70, 100, 100, 20);

                newFrame.setContentPane(secondPanel);
                newFrame.setSize(400, 400);
                secondPanel.setLayout(null);

                newLabel.setBounds(10, 60, 350, 20);
                secondPanel.add(newLabel);
                secondPanel.add(okButton);

                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newFrame.dispose();
                    }
                });

            }

            //show number of products
            if (e.getSource() == buttonNumber) {
                JFrame newFrame = new JFrame("Number of products");
                JPanel secondPanel = new JPanel();
                newFrame.setVisible(true);
                JLabel newLabel = new JLabel("Total number of products: " + ctrl.getTotalNumberOfProducts());
                JButton okButton = new JButton("OK ");
                okButton.setBounds(100, 100, 100, 20);

                newFrame.setContentPane(secondPanel);
                newFrame.setSize(350, 200);
                secondPanel.setLayout(null);

                newLabel.setBounds(10, 60, 200, 20);
                secondPanel.add(newLabel);
                secondPanel.add(okButton);

                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newFrame.dispose();
                    }
                });
            }

        }
    }


    public static void main(String[] args) {
        View v = new View();
    }


}
