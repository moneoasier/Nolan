using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.Button;

namespace NolanStatics
{
    public partial class Login : Form
    {
   
        public Login()
        {
            InitializeComponent();
            fillarray();
            
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
        

        private void btn_log_Click(object sender, EventArgs e)
        {
            if (validData())
            {
                if (userExists())
                {
                    this.Hide();

                    Menu frm = new Menu();

                    frm.Show();
                    this.Hide();
                } 
                else
                {
                    MessageBox.Show("The user doesn't exist or the password doesn't match");
                }
            }
            else
            {
                MessageBox.Show("You must enter valid values");
            }
        }

        private bool validData()
        {
            if (CheckEmail.IsValidEmail(txt_mail.Text) && !txt_pass.Text.Equals(""))
            {
                return true;
            }

            return false;
        }

        private void fillarray() {

            conexionbd conexion = new conexionbd();
            conexion.abrir();
            AutoCompleteStringCollection source = new AutoCompleteStringCollection();


            string sententzia = "Select * from dbo.app_users";
            try
            {
                SqlCommand comando = new SqlCommand(sententzia, conexion.conectarbd);
                SqlDataReader lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    source.Add(lector.GetValue(0).ToString());

                }
                txt_mail.AutoCompleteSource = AutoCompleteSource.CustomSource;
                txt_mail.AutoCompleteCustomSource = source;
            }
            catch
            {
                Console.WriteLine("Error SQL");
            }


        }

        private bool userExists()
        {
            conexionbd conexion = new conexionbd();
            conexion.abrir();

            bool exists = false;

            string sententzia = "Select * from dbo.app_users";
            try
            {
                SqlCommand comando = new SqlCommand(sententzia, conexion.conectarbd);
                SqlDataReader lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    if(lector.GetValue(0).Equals(txt_mail.Text)){
                        
                        if (lector.GetValue(1).Equals(txt_pass.Text))
                        {
                            exists = true;
                        }
                       
                    }
                    
                }
            }
            catch
            {
                Console.WriteLine("Error SQL");
            }

            return exists;
        }

        private void check_pass_CheckedChanged(object sender, EventArgs e)
        {
            if (check_pass.Checked)
            {
                txt_pass.UseSystemPasswordChar = false;
            }
            else
            {
                txt_pass.UseSystemPasswordChar = true;
            }
            
        }
    }
}
