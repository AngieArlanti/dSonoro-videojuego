package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class ImagePanel {    
     
    // Set up contraints so that the user supplied component and the
    // background image label overlap and resize identically
    private static final GridBagConstraints gbc;
    static {
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
    }
     
    /**
     * Wraps a Swing JComponent in a background image. Simply invokes the overloded
     * variant with Top/Leading alignment for background image.
     *
     * @param component - to wrap in the a background image
     * @param backgroundIcon - the background image (Icon)
     * @return the wrapping JPanel
     */
    public static JPanel wrapInBackgroundImage(JComponent component,
            Icon backgroundIcon) {
        return wrapInBackgroundImage(
                component,
                backgroundIcon,
                JLabel.TOP,
                JLabel.LEADING);
    }
     
    /**
     * Wraps a Swing JComponent in a background image. The vertical and horizontal
     * alignment of background image can be specified using the alignment
     * contants from JLabel.
     *
     * @param component - to wrap in the a background image
     * @param backgroundIcon - the background image (Icon)
     * @param verticalAlignment - vertical alignment. See contants in JLabel.
     * @param horizontalAlignment - horizontal alignment. See contants in JLabel.
     * @return the wrapping JPanel
     */
    public static JPanel wrapInBackgroundImage(JComponent component,
            Icon backgroundIcon,
            int verticalAlignment,
            int horizontalAlignment) {
         
        // make the passed in swing component transparent
        component.setOpaque(false);
         
        // create wrapper JPanel
        JPanel backgroundPanel = new JPanel(new GridBagLayout());
         
        // add the passed in swing component first to ensure that it is in front
        backgroundPanel.add(component, gbc);
         
        // create a label to paint the background image
        JLabel backgroundImage = new JLabel(backgroundIcon);
         
        // set minimum and preferred sizes so that the size of the image
        // does not affect the layout size
        backgroundImage.setPreferredSize(new Dimension(1,1));
        backgroundImage.setMinimumSize(new Dimension(1,1));
         
        // align the image as specified.
        backgroundImage.setVerticalAlignment(verticalAlignment);
        backgroundImage.setHorizontalAlignment(horizontalAlignment);
         
        // add the background label
        backgroundPanel.add(backgroundImage, gbc);
         
        // return the wrapper
        return backgroundPanel;
    }
}