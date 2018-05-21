package Controller;

import android.content.Context;
import android.database.Cursor;

import Conecction.SQLite;
import Modell.usuario;
//implementar el crud

public class ClsUsuario {

    SQLite db;

    public ClsUsuario(Context context) {
        db = new SQLite(context);
    }

    public void createUsuario(usuario us){
        db.getWritableDatabase().execSQL("INSERT INTO usuario(login, clave, estado) VALUES (" +
                " '"+ us.getLogin() +"' , '"+us.getClave()+"' , '"+us.getEstado()+" ')");
    }
    public Cursor readUsuario(){
        return db.getWritableDatabase().rawQuery("SELECT id_usuario, login, clave, estado FROM usuario ", null);
    }
    public Cursor readUsuario(String cond){
        return db.getWritableDatabase().rawQuery("SELECT id_usuario, login, clave, estado FROM usuario WHERE login='"+cond+"'",null);

    }
    public void updateusuario (usuario us){
        db.getWritableDatabase().execSQL("UPDATE usuario SET " +
                " clave = '"+us.getClave()+"' , estado = '"+us.getEstado()+"' " +
                " WHERE login = '"+us.getLogin()+"'");
    }
    public void deleteUsuario (String login){
        db.getWritableDatabase().execSQL("DELETE FROM usuario WHERE  login = '"+login+"' ");
    }
    public void close(){
        db.close();
    }
}
