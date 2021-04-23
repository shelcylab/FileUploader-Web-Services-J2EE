import com.servlet.Imagedata;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import service.ImageService;
import service.ImageServiceService;
import service.Imaged;


/**
 *
 * @author shelc
 */
public class Initial {
    public static void main(String[] args) throws InterruptedException {
        ImageServiceService service = new ImageServiceService();
        ImageService port = service.getImageServicePort();

AsyncHandler<Imaged> asyncHandler = new  AsyncHandler<Imaged>() {
@Override
public void handleResponse(Response<Imaged> response) {
try {
System.out.println("output: "+response.get().getData());
} catch (InterruptedException ex) {
Logger.getLogger(Initial.class.getName()).log(Level.SEVERE, null, ex);
} catch (ExecutionException ex) {
Logger.getLogger(Initial.class.getName()).log(Level.SEVERE, null, ex);
}
}
};


//Future<?> result = port.uploadAsync(filename, data);
//while(!result.isDone())
//{
//Thread.sleep(1000);
//}
}

    
}
