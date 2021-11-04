using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NolanStatics
{
    class conexionbd
    {
        string cadena = "Data Source=192.168.65.2;Initial Catalog=Nolan;Persist Security Info=True;User ID=admin;Password=Admin123";
        public SqlConnection conectarbd = new SqlConnection();

        public conexionbd()
        {
            conectarbd.ConnectionString = cadena;

        }

        public void abrir()
        {
            try
            {
                conectarbd.Open();
                Console.WriteLine("Conexión establecida");
                

            } catch(Exception ex)
            {
                Console.WriteLine("Error en la conexión de la BD"+ex.Message);
            }
        }

        public void cerrar()
        {
            conectarbd.Close();
        }
    }
}
