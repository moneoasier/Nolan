namespace NolanStatics
{
    partial class ProdKopForm
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
            this.prodKopDLL1 = new DLLs.ProdKopDLL();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // prodKopDLL1
            // 
            this.prodKopDLL1.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.prodKopDLL1.Location = new System.Drawing.Point(44, 56);
            this.prodKopDLL1.Name = "prodKopDLL1";
            this.prodKopDLL1.Size = new System.Drawing.Size(962, 503);
            this.prodKopDLL1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(260, 56);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(380, 37);
            this.label1.TabIndex = 2;
            this.label1.Text = "Produktuen Informazioa";
            // 
            // ProdKopForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.ClientSize = new System.Drawing.Size(946, 464);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.prodKopDLL1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "ProdKopForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "ProdKopForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private DLLs.ProdKopDLL prodKopDLL1;
        private System.Windows.Forms.Label label1;
    }
}