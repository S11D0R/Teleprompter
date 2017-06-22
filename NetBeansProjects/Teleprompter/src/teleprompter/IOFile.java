/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teleprompter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author temak
 */
public class IOFile {
    
    /**
     * Функция открытия фалов
     * @param jTextArea1
     * @param filePath 
     * @return  
     */
    public int openFunc(JTextArea jTextArea1, String filePath) {
        JFileChooser fileOpen = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileOpen.setFileFilter(filter);
        int ret = fileOpen.showDialog(null, "Открыть базу");
        if (ret == JFileChooser.APPROVE_OPTION) {
            try {
                File fileName = fileOpen.getSelectedFile();
                filePath = fileName.getAbsolutePath();
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                jTextArea1.read(reader, null);
//                String string;
//                while ((string = reader.readLine()) != null) {
//                jTextArea1.append(string + "\n");
//                }
//                jTextArea1.setCaretPosition(0);
                reader.close();
                return ret;
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Файл не найден");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Проблема с доступом к файлу по адресу " + filePath);
            }
        }
        return ret;
    }
    
}

