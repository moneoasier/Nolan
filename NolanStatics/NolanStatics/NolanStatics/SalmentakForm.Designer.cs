namespace NolanStatics
{
    partial class SalmentakForm
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
            this.salmentaDLL1 = new DLLs.SalmentaDLL();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // salmentaDLL1
            // 
            this.salmentaDLL1.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.salmentaDLL1.Location = new System.Drawing.Point(-6, 48);
            this.salmentaDLL1.Name = "salmentaDLL1";
            this.salmentaDLL1.Size = new System.Drawing.Size(962, 503);
            this.salmentaDLL1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(289, 77);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(367, 37);
            this.label1.TabIndex = 1;
            this.label1.Text = "Salmenten Informazioa";
            // 
            // SalmentakForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.ClientSize = new System.Drawing.Size(946, 464);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.salmentaDLL1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "SalmentakForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "SalmentakForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private DLLs.SalmentaDLL salmentaDLL1;
        private System.Windows.Forms.Label label1;
    }
}