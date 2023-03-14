package com.example.drawerfamex.backend;

import com.example.drawerfamex.backend.interfaces.CustomersClient;
import com.example.drawerfamex.backend.interfaces.LoginClient;
import com.example.drawerfamex.backend.interfaces.SecurityClient;
import com.example.drawerfamex.backend.models.customers.Customer;
import com.example.drawerfamex.backend.models.customers.MessageCustomer;
import com.example.drawerfamex.backend.models.login.MessageLogin;
import com.example.drawerfamex.backend.models.login.Role;
import com.example.drawerfamex.backend.models.login.User;
import com.example.drawerfamex.backend.utils.FamexException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataService {

    public Customer registerCustomer(Customer customer) throws FamexException {
        // preparamos objeto de respuesta

        try {
            // creamos cliente http retrofit
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://a038559e72dc64ec4a602a8d10b97c08-26840281.us-east-2.elb.amazonaws.com:8762")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            // creamos interfaz para cliente de http
            CustomersClient service = retrofit.create(CustomersClient.class);

            // creamos payload para el request
            MessageCustomer message = new MessageCustomer();
            message.set
            // acaba payload request

            // configura la llamada
            Call<MessageCustomer> call = service.registerCustomer(message);

            // ejecuta la llamada
            call.enqueue(new Callback<MessageLogin>() {

                @Override
                /**
                 * Este metodo se ejecuta cuando se realizo una conexion correcta. Aplica para cualquier codigo http
                 */
                public void onResponse(Call<MessageLogin> call, Response<MessageLogin> response) {
                    // imprimimos codigo HTTP de respuesta
                    System.out.println("Codigo http respuesta: " + response.code());

                    // extraemos el body
                    MessageLogin messageResponse = response.body();

                    // validamos el body
                    if (messageResponse.getStatusOperation().getStatus() == 0 && messageResponse.getUsers() != null && !messageResponse.getUsers().isEmpty()) {
                        // extraemos datos necesarios de la respuesta
                        User userResponse = messageResponse.getUsers().get(0);

                        responseMap.put("RefreshToken", userResponse.getAccessToken());
                        responseMap.put("AuthToken", userResponse.getRefreshToken());
                        responseMap.put("Username", userResponse.getUsername());
                    } else {
                        // si la validacion no es correcta, se imprime un mensaje de error
                        System.out.println("Error en el servicio: Codigo"
                                + messageResponse.getStatusOperation().getStatus() + ", Descripcion: "
                                + messageResponse.getStatusOperation().getDescription());
                    }
                }

                @Override
                /**
                 * Este metodo se ejecuta cuando sucede un error en la llamada (no en el servicio)
                 */
                public void onFailure(Call<MessageLogin> call, Throwable throwable) {
                    System.out.println("Error en el servicio: " + throwable.getMessage());
                }
            });
        } catch (Exception e) {
            // cachamos alguna excepcion en el proceso de configuracion de cliente y de payload
            System.out.println("Error en la llamada: " + e.getMessage());
        }

        // regresamos la respuesta
        return customer;
    }
    public HashMap<String, String> login(String username, String password) throws FamexException {
        // preparamos objeto de respuesta
        final HashMap<String, String> responseMap = new HashMap<>();

        try {
            // creamos cliente http retrofit
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://a038559e72dc64ec4a602a8d10b97c08-26840281.us-east-2.elb.amazonaws.com:8762")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            // creamos interfaz para cliente de http
            LoginClient service = retrofit.create(LoginClient.class);

            // creamos payload para el request
            MessageLogin message = new MessageLogin();

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            List<User> users = new ArrayList<>();

            users.add(user);

            message.setUsers(users);
            // acaba payload request

            // configura la llamada
            Call<MessageLogin> call = service.login(message);

            // ejecuta la llamada
            call.enqueue(new Callback<MessageLogin>() {

                @Override
                /**
                 * Este metodo se ejecuta cuando se realizo una conexion correcta. Aplica para cualquier codigo http
                 */
                public void onResponse(Call<MessageLogin> call, Response<MessageLogin> response) {
                    // imprimimos codigo HTTP de respuesta
                    System.out.println("Codigo http respuesta: " + response.code());

                    // extraemos el body
                    MessageLogin messageResponse = response.body();

                    // validamos el body
                    if (messageResponse.getStatusOperation().getStatus() == 0 && messageResponse.getUsers() != null && !messageResponse.getUsers().isEmpty()) {
                        // extraemos datos necesarios de la respuesta
                        User userResponse = messageResponse.getUsers().get(0);

                        responseMap.put("RefreshToken", userResponse.getAccessToken());
                        responseMap.put("AuthToken", userResponse.getRefreshToken());
                        responseMap.put("Username", userResponse.getUsername());
                    } else {
                        // si la validacion no es correcta, se imprime un mensaje de error
                        System.out.println("Error en el servicio: Codigo"
                                + messageResponse.getStatusOperation().getStatus() + ", Descripcion: "
                                + messageResponse.getStatusOperation().getDescription());
                    }
                }

                @Override
                /**
                 * Este metodo se ejecuta cuando sucede un error en la llamada (no en el servicio)
                 */
                public void onFailure(Call<MessageLogin> call, Throwable throwable) {
                    System.out.println("Error en el servicio: " + throwable.getMessage());
                }
            });
        } catch (Exception e) {
            // cachamos alguna excepcion en el proceso de configuracion de cliente y de payload
            System.out.println("Error en la llamada: " + e.getMessage());
        }

        // regresamos la respuesta
        return responseMap;
    }

    public HashMap<String, String> createUser(String username, String password) throws FamexException {
        final HashMap<String, String> responseMap = new HashMap<>();

        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://a038559e72dc64ec4a602a8d10b97c08-26840281.us-east-2.elb.amazonaws.com:8762/security/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            SecurityClient service = retrofit.create(SecurityClient.class);

            MessageLogin message = new MessageLogin();

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            List<User> users = new ArrayList<>();

            users.add(user);

            message.setUsers(users);

            //  private String username; // "test_donde3@gmail.com",
            //    private String password; // "!QAZ2wsx",
            //    private String firstName; // "test",
            //    private String lastName; // "test",
            //    private String email; // "test_donde3@gmail.com",

            //

            Call<MessageLogin> call = service.createUser(message);

            call.enqueue(new Callback<MessageLogin>() {

                @Override
                public void onResponse(Call<MessageLogin> call, Response<MessageLogin> response) {
                    System.out.println("Codigo http respuesta: " + response.code());
                    MessageLogin messageResponse = response.body();

                    if (messageResponse.getStatusOperation().getStatus() == 0 && messageResponse.getUsers() != null && !messageResponse.getUsers().isEmpty()) {
                        User userResponse = messageResponse.getUsers().get(0);

                        responseMap.put("RefreshToken", userResponse.getAccessToken());
                        responseMap.put("AuthToken", userResponse.getRefreshToken());
                        responseMap.put("Username", userResponse.getUsername());
                    } else {
                        System.out.println("Error en el servicio: Codigo"
                                + messageResponse.getStatusOperation().getStatus() + ", Descripcion: "
                                + messageResponse.getStatusOperation().getDescription());
                    }
                }

                @Override
                public void onFailure(Call<MessageLogin> call, Throwable throwable) {
                    System.out.println("Error en el servicio: " + throwable.getMessage());
                }
            });
        } catch (Exception e) {
            System.out.println("Error en la llamada: " + e.getMessage());
        }

        return responseMap;
    }

    public HashMap<String, String> updateUser(String firstName, String lastName) throws FamexException {
        final HashMap<String, String> responseMap = new HashMap<>();

        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://a038559e72dc64ec4a602a8d10b97c08-26840281.us-east-2.elb.amazonaws.com:8762/security/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            SecurityClient service = retrofit.create(SecurityClient.class);

            MessageLogin message = new MessageLogin();

            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);

            List<User> users = new ArrayList<>();

            users.add(user);

            message.setUsers(users);

            Call<MessageLogin> call = service.updateUser(message);

            call.enqueue(new Callback<MessageLogin>() {

                @Override
                public void onResponse(Call<MessageLogin> call, Response<MessageLogin> response) {
                    System.out.println("Codigo http respuesta: " + response.code());
                    MessageLogin messageResponse = response.body();

                    if (messageResponse.getStatusOperation().getStatus() == 0 && messageResponse.getUsers() != null && !messageResponse.getUsers().isEmpty()) {
                        User userResponse = messageResponse.getUsers().get(0);

                        responseMap.put("RefreshToken", userResponse.getAccessToken());
                        responseMap.put("AuthToken", userResponse.getRefreshToken());
                        responseMap.put("Username", userResponse.getUsername());
                    } else {
                        System.out.println("Error en el servicio: Codigo"
                                + messageResponse.getStatusOperation().getStatus() + ", Descripcion: "
                                + messageResponse.getStatusOperation().getDescription());
                    }
                }

                @Override
                public void onFailure(Call<MessageLogin> call, Throwable throwable) {
                    System.out.println("Error en el servicio: " + throwable.getMessage());
                }
            });
        } catch (Exception e) {
            System.out.println("Error en la llamada: " + e.getMessage());
        }

        return responseMap;
    }


    public HashMap<String, String> registerCustomer(String firstName, String lastName) throws FamexException {
        final HashMap<String, String> responseMap = new HashMap<>();

        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://a038559e72dc64ec4a602a8d10b97c08-26840281.us-east-2.elb.amazonaws.com:8762/security/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            SecurityClient service = retrofit.create(SecurityClient.class);

            MessageLogin message = new MessageLogin();

            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);

            // private String segment; //"x",
            //    private String idUser; // "121212",
            //    private String userId; //"1212",
            //    private String firstName; //"Mauricio",
            //    private String lastName; //"Mendoza",
            //    private String motherMaidenName; //"Mendoza",
            //    private DateFormat birthDate; //"21/10/1997",
            //    private Boolean active; //true,
            //    private Integer idOccupation; // 1,
            //    private Integer idEconomicActivity; // "1",
            //    private String gender;// "H",
            //    private String expirationId; //"",
            //    private String numberId; // "",
            //    private String countryOfIssue; //"",
            //    private String nationality; //"MX",
            //    private String birthState; //"MX",
            //    private String photo;// "",
            //    //emails
            //    private List<EmailCustomer> emails;
            //    //phones
            //    private List<PhoneCustomer> phones;
            //    //adresses
            //    private List<AddressCustomer> addresses;
            //    //invoiceInfo
            //    private InvoiceInfo invoiceinfo;
            //    //businessInfo
            //    private BusinessInfo businessInfo;

            List<User> users = new ArrayList<>();

            users.add(user);

            message.setUsers(users);

            Call<MessageLogin> call = service.updateUser(message);

            call.enqueue(new Callback<MessageLogin>() {

                @Override
                public void onResponse(Call<MessageLogin> call, Response<MessageLogin> response) {
                    System.out.println("Codigo http respuesta: " + response.code());
                    MessageLogin messageResponse = response.body();

                    if (messageResponse.getStatusOperation().getStatus() == 0 && messageResponse.getUsers() != null && !messageResponse.getUsers().isEmpty()) {
                        User userResponse = messageResponse.getUsers().get(0);

                        responseMap.put("RefreshToken", userResponse.getAccessToken());
                        responseMap.put("AuthToken", userResponse.getRefreshToken());
                        responseMap.put("Username", userResponse.getUsername());
                    } else {
                        System.out.println("Error en el servicio: Codigo"
                                + messageResponse.getStatusOperation().getStatus() + ", Descripcion: "
                                + messageResponse.getStatusOperation().getDescription());
                    }
                }

                @Override
                public void onFailure(Call<MessageLogin> call, Throwable throwable) {
                    System.out.println("Error en el servicio: " + throwable.getMessage());
                }
            });
        } catch (Exception e) {
            System.out.println("Error en la llamada: " + e.getMessage());
        }

        return responseMap;
    }
}






