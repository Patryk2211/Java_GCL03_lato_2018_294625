package SpringBoot.Controller;

import SpringBoot.PictureDao.Picture;
import SpringBoot.PictureDao.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


@Controller
@PropertySource("classpath:application.properties")
public class MainController
{
    @Value("${folderPath}")
    private String path;
    private List<Picture> listOfImages;

    @PostConstruct
    public void refreshList() {
        listOfImages=new ArrayList<Picture>();
        BufferedImage readImage = null;
        String name="";
        int h=0,w=0;
        String resulution="";
        long size=0;
        Picture.clearid();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles!=null)
        {
            for (File f: listOfFiles) {
                Picture tempImage;
                try {
                    readImage = ImageIO.read(f);
                    name = f.getName();
                    size = f.length();
                    w = readImage.getWidth();
                    h = readImage.getHeight();
                } catch (IOException e) {
                    readImage = null;
                    e.printStackTrace();
                }

                BasicFileAttributes attr;
                try {
                    attr = Files.readAttributes(Paths.get(f.getPath()), BasicFileAttributes.class);
                    String time= String.valueOf(attr.creationTime());
                    resulution=w+"x"+h;
                    tempImage = new Picture(name, resulution, size, time);
                    listOfImages.add(tempImage);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @RequestMapping(value = "/gallery/pictures", method = RequestMethod.GET)
    @ResponseBody
    public List<Picture> allPictures() {
        listOfImages=new ArrayList<Picture>();
        BufferedImage readImage = null;
        String name="";
        int h=0,w=0;
        String resulution="";
        long size=0;
        Picture.clearid();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles!=null)
        {
            for (File f: listOfFiles) {
                Picture tempImage;
                try {
                    readImage = ImageIO.read(f);
                    name = f.getName();
                    size = f.length();
                    w = readImage.getWidth();
                    h = readImage.getHeight();
                } catch (IOException e) {
                    readImage = null;
                    e.printStackTrace();
                }

                BasicFileAttributes attr;
                try {
                    attr = Files.readAttributes(Paths.get(f.getPath()), BasicFileAttributes.class);
                    String time= String.valueOf(attr.creationTime());
                    resulution=w+"x"+h;
                    tempImage = new Picture(name, resulution, size, time);
                    listOfImages.add(tempImage);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listOfImages;
    }





    private MediaType getContentType( String name )
    {
        int index = name.lastIndexOf( "." );

        if( index == -1 )
            return null;

        String extension = name.substring( index + 1 );

        switch( extension.toLowerCase() )
        {
            case "png": return MediaType.IMAGE_PNG;
            case "gif": return MediaType.IMAGE_GIF;
            case "jpg": return MediaType.IMAGE_JPEG;
        }

        return null;
    }

    private ResponseEntity<byte[]> createImageResponse( MediaType type, byte[] data )
    {
        return createImageResponse( type, data, HttpStatus.OK );
    }

    private ResponseEntity<byte[]> createImageResponse( MediaType type, byte[] data, HttpStatus status )
    {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType( type );

        return new ResponseEntity<>( data, headers, status );
    }

    private Picture getImage(int index )
    {
        if( index > 0 && index < this.listOfImages.size() + 1 )
        {
            for( Picture el : this.listOfImages )
            {
                if( index == el.getIndex() )
                    return el;
            }
        }

        return null;
    }

    @RequestMapping(value = "/gallery/picture/{index}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> getPicture( @PathVariable( value = "index" ) int index )
    {
        Picture image = this.getImage( index );

        if( image != null )
        {
            MediaType type = this.getContentType( image.getName() );

            if( type != null )
            {
                File file = new File( this.path + "/" + image.getName() );

                try
                {
                    byte[] data = new byte[ (int) file.length() ];

                    try( FileInputStream stream = new FileInputStream( file ) )
                    {
                        stream.read( data );
                    }

                    return this.createImageResponse( type, data );
                }
                catch ( Exception e )
                {
                    //TODO: logs

                    e.printStackTrace();
                }
            }
        }

        return this.createImageResponse( MediaType.IMAGE_JPEG, new byte[ 0 ], HttpStatus.NOT_FOUND );
    }

    @RequestMapping(value = "/gallery/delete-picture/{index}", method = {RequestMethod.GET})
    @ResponseBody
    public Result deleteImage(@PathVariable(value = "index") int index) {

            String nameToDelete = "";
            boolean resDel = false;
            Result result = new Result();
            System.out.println(listOfImages);
            for (Picture img : listOfImages) {
                Picture tempImage = img;
                if (tempImage.getIndex() == index) {
                    nameToDelete = tempImage.getName();
                    break;
                }
            }

            if (nameToDelete.equals(""))
                result.setResult(false);

            File folder = new File(path);
            File[] listOfFiles = folder.listFiles();
            for (File f : listOfFiles) {
                if (f.getName().equals(nameToDelete)) {
                    resDel = f.delete();
                }
            }
            refreshList();
            if (resDel == true)
                result.setResult(true);
            else
                result.setResult(false);

            return result;

    }


    @RequestMapping(value = { "/", "/gallery" }, method = RequestMethod.GET)
    public ModelAndView getFile() throws IOException {
            InputStream is=null;
            List<Picture> testList=new ArrayList<Picture>();

            return new ModelAndView("images", "images", this.listOfImages );
    }
}

