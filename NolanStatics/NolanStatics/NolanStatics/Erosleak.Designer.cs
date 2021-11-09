namespace NolanStatics
{
    partial class Erosleak
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
            this.res_partnerDLL1 = new DLLs.res_partnerDLL();
            this.SuspendLayout();
            // 
            // res_partnerDLL1
            // 
            this.res_partnerDLL1.Location = new System.Drawing.Point(-6, 12);
            this.res_partnerDLL1.Name = "res_partnerDLL1";
            this.res_partnerDLL1.Size = new System.Drawing.Size(820, 629);
            this.res_partnerDLL1.TabIndex = 0;
            // 
            // Erosleak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.res_partnerDLL1);
            this.Name = "Erosleak";
            this.Text = "Erosleak";
            this.ResumeLayout(false);

        }

        #endregion

        private DLLs.res_partnerDLL res_partnerDLL1;
    }
}