
public class Constants {

    public static final String URL = "https://igym-igym-dev.azurewebsites.net/";

    //user registration data's
    public static final String EMAIL = "teszteszter80@freemail.hu";  //csak a vizsgaremek leadásakor teszem aktívvá a valid login metódust
    public static final String PASSWORD = "Ca123456789";
    public static final String NOT_VALID_PASSWORD = "Ca123";
    public static final String NOT_MATCH_PASSWORD = "Ca123456788";

    //user login data's
    public static final String USER_EMAIL = EMAIL;   //a regisztrált user email címe
    public static final String USER_PASSWORD = PASSWORD;   //a regisztrált user jelszava
    public static final String USER_WRONG_PASSWORD = NOT_MATCH_PASSWORD;   //a regisztrált user hibás jelszava

    //trainer login data's
    public static final String TRAINER_EMAIL = "tesztedzo@igym.hu";
    public static final String TRAINER_PASSWORD = "123456";
    public static final String TRAINER_WRONG_PASSWORD = "123455";

    //user detail's modification
    public static final String USER_FIRSTNAME = "Eszter";
    public static final String USER_SURNAME = "Teszt";
    public static final String USER_NICKNAME = "Teszti";
    public static final String USER_FULLNAME = USER_FIRSTNAME + USER_SURNAME;
    public static final String USER_COUNTRY = "Magyarország";
    public static final String USER_POSTAL_CODE = "7100";
    public static final String USER_CITY = "Szekszárd";
    public static final String USER_ADDRESS = "Széchenyi u. 55.";
    public static final String USER_OLD_PASSWORD = PASSWORD;
    public static final String USER_NEW_PASSWORD = "De123456789";
    public static final String USER_CONFIRM_PASSWORD = USER_NEW_PASSWORD;

    //trainer data's
    public static final String TRAINER_FIRSTNAME = "Edző";
}
