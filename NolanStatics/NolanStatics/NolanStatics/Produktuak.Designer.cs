namespace NolanStatics
{
    partial class Produktuak
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
            this.product_templateDLL1 = new DLLs.product_templateDLL();
            this.SuspendLayout();
            // 
            // product_templateDLL1
            // 
            this.product_templateDLL1.Location = new System.Drawing.Point(12, 12);
            this.product_templateDLL1.Name = "product_templateDLL1";
            this.product_templateDLL1.Size = new System.Drawing.Size(975, 704);
            this.product_templateDLL1.TabIndex = 0;
            // 
            // Produktuak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.product_templateDLL1);
            this.Name = "Produktuak";
            this.Text = "Produktuak";
            this.ResumeLayout(false);

        }

        #endregion

        private DLLs.product_templateDLL product_templateDLL1;
    }
}