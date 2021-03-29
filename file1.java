public class Clazz {
    @Override
    public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
        ListCellRenderer<Object> renderer = comboBox.getRenderer();
        Component c;

        c = renderer.getListCellRendererComponent(
                listBox, comboBox.getSelectedItem(), -1, false, false );

        // Fix for 4238829: should lay out the JPanel.
        boolean shouldValidate = false;
        if (c instanceof JPanel)  {
            shouldValidate = true;
        }

        if (c instanceof UIResource) {
            c.setName("ComboBox.renderer");
        }

        boolean force = forceOpaque && c instanceof JComponent;
        if (force) {
            ((JComponent)c).setOpaque(false);
        }

        int x = bounds.x, y = bounds.y, w = bounds.width, h = bounds.height;
        if (padding != null) {
            x = bounds.x + padding.left;
            y = bounds.y + padding.top;
            w = bounds.width - (padding.left + padding.right);
            h = bounds.height - (padding.top + padding.bottom);
        }

        currentValuePane.paintComponent(g, c, comboBox, x, y, w, h, shouldValidate);

        if (force) {
            ((JComponent)c).setOpaque(true);
        }
    }
}
