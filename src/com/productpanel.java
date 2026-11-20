package com;

import com.Entity.ProductEntity;
import com.service.Proservice;
import com.service.ProserviceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


// 文件名是 productpanel.java，故类不加 public（Java 要求 public 类与文件名完全一致）
class ProductPanel extends JPanel {


    // 1. 声明 Service
    private final Proservice productService = new ProserviceImpl();

    // 2. UI 组件
    private final DefaultTableModel model;
    private final JTable table;
    private final JLabel countLabel = new JLabel("（共 0 条）");

    public ProductPanel() {
        setLayout(new BorderLayout(8, 8));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ================= 1. 顶部工具栏 =================
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));

        JButton refreshBtn = new JButton("刷新");
        JButton addBtn = new JButton("添加");
        JButton editBtn = new JButton("编辑");
        JButton deleteBtn = new JButton("删除");

        // 绑定按钮事件
        refreshBtn.addActionListener(e -> loadData());
       // addBtn.addActionListener(e -> showAddDialog());
     //   editBtn.addActionListener(e -> showEditDialog());
     //  deleteBtn.addActionListener(e -> deleteSelected());

        // 把按钮加进工具栏
        topPanel.add(refreshBtn);
        topPanel.add(addBtn);
        topPanel.add(editBtn);
        topPanel.add(deleteBtn);
        topPanel.add(countLabel);

        // ================= 2. 中间表格 =================
        model = new DefaultTableModel(new String[]{"PID", "商品名称", "单价", "库存"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 禁止双击直接编辑
            }
        };
        table = new JTable(model);
        table.setRowHeight(25);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 只能单选
        JScrollPane scrollPane = new JScrollPane(table);

        // ================= 3. 组装面板 =================
        add(topPanel, BorderLayout.NORTH);   // 顶部放按钮
        add(scrollPane, BorderLayout.CENTER); // 中间放表格

        // 4. 初始加载数据
        loadData();
    }

    /** 查询全部商品并刷新表格 */
    private void loadData() {
        model.setRowCount(0);
        List<ProductEntity> list = productService.findALL();
        for (ProductEntity p : list) {
            model.addRow(new Object[]{p.getPid(), p.getPname(), p.getPrice(), p.getStock()});
        }
        countLabel.setText("（共 " + list.size() + " 条）");
    }

        /**
         * 添加功能（弹窗）
         */
        private void showAddDialog() {
            JTextField nameField = new JTextField();
            JTextField priceField = new JTextField();
            JTextField stockField = new JTextField();

            JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
            inputPanel.add(new JLabel("商品名称："));
            inputPanel.add(nameField);
            inputPanel.add(new JLabel("单价："));
            inputPanel.add(priceField);
            inputPanel.add(new JLabel("库存："));
            inputPanel.add(stockField);

            int result = JOptionPane.showConfirmDialog(this, inputPanel, "添加商品", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                try {
                    ProductEntity p = new ProductEntity();
                    p.setPname(nameField.getText().trim());
                    p.setPrice(Double.parseDouble(priceField.getText().trim()));
                    p.setStock(Integer.parseInt(stockField.getText().trim()));

                    boolean success = productService.addProduct(p);
                    if (success) {
                        JOptionPane.showMessageDialog(this, "添加成功！");
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "添加失败！可能商品名称为空或价格为负。");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "单价和库存必须输入数字！", "格式错误", JOptionPane.ERROR_MESSAGE);
                }
            }
    }
}
