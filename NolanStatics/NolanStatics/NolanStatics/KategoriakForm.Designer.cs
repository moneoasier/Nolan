namespace NolanStatics
{
    partial class KategoriakForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.kategoriakDLL1 = new DLLs.KategoriakDLL();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // kategoriakDLL1
            // 
            this.kategoriakDLL1.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.kategoriakDLL1.Location = new System.Drawing.Point(-9, -4);
            this.kategoriakDLL1.Name = "kategoriakDLL1";
            this.kategoriakDLL1.Size = new System.Drawing.Size(906, 395);
            this.kategoriakDLL1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(169, 54);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(517, 37);
            this.label1.TabIndex = 2;
            this.label1.Text = "Produktu Kategorien Informazioa";
            // 
            // KategoriakForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.ClientSize = new System.Drawing.Size(930, 425);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.kategoriakDLL1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "KategoriakForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "KategoriakForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private DLLs.KategoriakDLL kategoriakDLL1;
        private System.Windows.Forms.Label label1;
    }
}