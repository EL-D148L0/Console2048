package max.sander;

public class BadGameLogicException extends Exception
{
    public BadGameLogicException (String str)
    {
        // calling the constructor of parent Exception
        super(str);
    }
}

