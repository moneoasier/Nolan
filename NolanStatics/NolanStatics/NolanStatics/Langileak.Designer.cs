namespace NolanStatics
{
    partial class Langileak
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
            this.app_usersDLL1 = new DLLs.app_usersDLL();
            this.SuspendLayout();
            // 
            // app_usersDLL1
            // 
            this.app_usersDLL1.Location = new System.Drawing.Point(27, 0);
            this.app_usersDLL1.Name = "app_usersDLL1";
            this.app_usersDLL1.Size = new System.Drawing.Size(778, 516);
            this.app_usersDLL1.TabIndex = 0;
            // 
            // Langileak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.app_usersDLL1);
            this.Name = "Langileak";
            this.Text = "Langileak";
            this.ResumeLayout(false);

        }

        #endregion

        private DLLs.app_usersDLL app_usersDLL1;
    }
}