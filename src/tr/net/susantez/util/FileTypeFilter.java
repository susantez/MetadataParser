package tr.net.susantez.util;

/**
 * Created by serkan.susantez on 4/11/2017.
 */
import java.io.File;
import javax.swing.filechooser.FileFilter;

public class FileTypeFilter extends FileFilter
{
    private String extension;
    private String description;

    public FileTypeFilter(String extension, String description)
    {
        this.extension = extension;
        this.description = description;
    }

    public boolean accept(File file)
    {
        if (file.isDirectory()) {
            return true;
        }
        return file.getName().endsWith(this.extension);
    }

    public String getDescription()
    {
        return this.description + String.format(" (*%s)", new Object[] { this.extension });
    }
}
