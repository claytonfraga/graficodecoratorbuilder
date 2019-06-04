package principal;

import grafico.presenter.MainPresenter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Thiago
 */
public final class Main {

    public static void main(String[] args) {
        try {
            String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(lookAndFeel);
            new MainPresenter();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "Falha na inicialização: \n" + ex.getMessage());
            Logger.getLogger(MainPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Falha na inicialização: \n" + ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
