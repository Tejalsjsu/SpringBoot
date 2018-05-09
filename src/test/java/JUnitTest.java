import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

import com.controller.BidController;
import com.entity.LoginInResponse;
import com.entity.tblbids;
import com.entity.tbllogin;
import com.entity.tblproject;
import com.repository.BidRepository;
import com.repository.ProjectRepository;
import com.service.LoginService;

public class JUnitTest extends ServerApplicationTests {
	@Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    
    @Autowired
    BidRepository bidRepository;
    
    @Autowired
    BidController bidController;
    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    private LoginService loginService;
    
    @Before(value = "")
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
   }
    
   
    @Test
    public void login() throws Exception{
    	 tbllogin mocklogin = new tbllogin();
    	 mocklogin.setUserEmail("tejp@gmail.com");
    	 mocklogin.setUserPassword("tej");
    	 LoginInResponse logInResponse =  loginService.login("tej@gmail.com", "tej");
    	 assertThat(logInResponse.getResponse().getStatus()).isEqualTo("success");
    	
    }
    
   
    @Test
    public void placeBid() throws Exception{
    	tblbids tblbids = new tblbids();
    	tblbids.setBidAmount(100);
    	tblbids.setCompletionDays(15);
    	tblbids.setProjectId(3);
    	tblbids.setUserId(10);
    	bidController.addNewBid(tblbids);
    	String expected = "success";
    	assertEquals(expected,bidController.addNewBid(tblbids));
    	
    }
    @Test
    public void SignUp() throws Exception{
    	tbllogin mocklogin = new tbllogin();
   	 	mocklogin.setUserEmail("tejp@gmail.com");
   	 	mocklogin.setUserPassword("tej");
   	 	mocklogin.setUserName("tejalp");
   	 	LoginInResponse logInResponse =  loginService.addUser(mocklogin);
   	 	assertThat(logInResponse.getResponse().getStatus()).isEqualTo("success");
    	
    }
    
    @Test
    public void fetchAllProjects() throws Exception{
    	Iterable<tblproject> projects = projectRepository.findByemployerId(3);
    	String expected = "15";
    	assertEquals(expected,projects);
    	
    }



}
