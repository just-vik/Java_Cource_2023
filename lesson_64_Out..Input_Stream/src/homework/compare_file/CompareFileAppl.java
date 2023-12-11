package homework.compare_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class CompareFileAppl {
    public static void main(String[] args) {
        //����� ��� ���������
        String file1 = "./src/homework/compare_file/compare_files/file1.txt";
        String file2 = "./src/homework/compare_file/compare_files/file2.txt";
        //������� ���������� �����
        writeToFile(file1, "file1 for test");
        writeToFile(file2, "file2 for test");
        //���������� �����
        compareFiles(file1, file2);

    }

    //����� ��� ������ � ����
    private static void writeToFile(String file, String content) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(content.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //��������� ������
    private static void compareFiles(String filePath1, String filePath2) {
        try (FileInputStream file1 = new FileInputStream(filePath1);
             FileInputStream file2 = new FileInputStream(filePath2)) {
            if (file1.available() != file2.available()) {
                System.out.println("����� ���������� �� �����.");
                return;
            }
            int bytes1;
            int bytes2;
            while ((bytes1 = file1.read(new byte[1024])) != -1) {
                bytes2 = file2.read(new byte[1024]);
                if (bytes1 != bytes2 || !Arrays.equals(Arrays.copyOf(new byte[1024], bytes1), Arrays.copyOf(new byte[1024], bytes2))) {
                    System.out.println("����� �� ����������.");
                    return;
                }
            }
            System.out.println("����� ����������.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
