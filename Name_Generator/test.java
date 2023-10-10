package Name_Generator;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.*;

public class test 
{
        NameGenerator test = new NameGenerator();

        @Test
        public void IsFromReach()
        {
            assertEquals("Should return 1", 1, test.choice_Region("Land of Green"));
        }

        @Test
        public void IsHuman()
        {
            assertEquals("Should return 1", 1, test.choice_Race("Human"));
        }

        @Test
        public void IsMale()
        {
            assertEquals("Should return 1", 1, test.choice_Gender("Male"));
        }

        @Test
        public void IsFemale()
        {
            assertEquals("Should return 1", 2, test.choice_Gender("Female"));
        }
        
        @Test
        public void IsRegularName() throws IOException
        {
            int len = 6;
            assertEquals("Should return 6 Names", 6, len);
        }

        @Test
        public void IsNobleName()
        {
            
        }
}
