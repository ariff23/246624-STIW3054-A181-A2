import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class WritePdf {
    //public void writepdf(){
    public static void main(String[] args) {

        readexcel test= new readexcel();//call class
        List<String>firsrow = test.All();

        try {

            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream("D:\\intelj\\assgmnt 2\\chessResultsList.pdf"));
            document.open();

            for(int i = 0; i < 4; i++){
              document.add(new Paragraph(""+firsrow.get(i)));
           }

            PdfPTable table = new PdfPTable(6); // 6 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table
            //Set Column widths
            float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f};
            table.setWidths(columnWidths);

            for (int z=0;z<readexcel.studentdata.size();z++){
                table.addCell(readexcel.studentdata.get(z).getNo());
                table.addCell(readexcel.studentdata.get(z).getName());
                table.addCell(readexcel.studentdata.get(z).getFieldid());
                table.addCell(readexcel.studentdata.get(z).getFed());
                table.addCell(readexcel.studentdata.get(z).getRtg());
                table.addCell(readexcel.studentdata.get(z).getClub());
            }
            document.add(table);
            document.close();

        } catch (DocumentException e)
        {
            e.printStackTrace();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}














