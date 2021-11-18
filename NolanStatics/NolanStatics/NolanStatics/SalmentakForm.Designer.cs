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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(SalmentakForm));
            this.salmentaDLL1 = new DLLs.SalmentaDLL();
            this.label1 = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            this.SuspendLayout();
            // 
            // salmentaDLL1
            // 
            this.salmentaDLL1.BackColor = System.Drawing.Color.Transparent;
            this.salmentaDLL1.Location = new System.Drawing.Point(270, 262);
            this.salmentaDLL1.Name = "salmentaDLL1";
            this.salmentaDLL1.Size = new System.Drawing.Size(495, 190);
            this.salmentaDLL1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(83, 123);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(315, 33);
            this.label1.TabIndex = 1;
            this.label1.Text = "Salmenten Informazioa";
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.Transparent;
            this.panel1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("panel1.BackgroundImage")));
            this.panel1.Location = new System.Drawing.Point(996, 68);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(54, 50);
            this.panel1.TabIndex = 2;
            this.panel1.Click += new System.EventHandler(this.panel1_Click);
            // 
            // SalmentakForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(1126, 620);
            this.ControlBox = false;
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.salmentaDLL1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "SalmentakForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "SalmentakForm";
            this.TopMost = true;
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private DLLs.SalmentaDLL salmentaDLL1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel panel1;
    }
}