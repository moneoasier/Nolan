namespace DLLs
{
    partial class LangileakDLL
    {
        /// <summary> 
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de componentes

        /// <summary> 
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.nolanDataSet = new DLLs.NolanDataSet();
            this.appusersBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.app_usersTableAdapter = new DLLs.NolanDataSetTableAdapters.app_usersTableAdapter();
            this.hremployeeBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.hr_employeeTableAdapter = new DLLs.NolanDataSetTableAdapters.hr_employeeTableAdapter();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.hremployeeBindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.idDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.work_email = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.user_id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.nolanDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.appusersBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.hremployeeBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.hremployeeBindingSource1)).BeginInit();
            this.SuspendLayout();
            // 
            // nolanDataSet
            // 
            this.nolanDataSet.DataSetName = "NolanDataSet";
            this.nolanDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // appusersBindingSource
            // 
            this.appusersBindingSource.DataMember = "app_users";
            this.appusersBindingSource.DataSource = this.nolanDataSet;
            // 
            // app_usersTableAdapter
            // 
            this.app_usersTableAdapter.ClearBeforeFill = true;
            // 
            // hremployeeBindingSource
            // 
            this.hremployeeBindingSource.DataMember = "hr_employee";
            this.hremployeeBindingSource.DataSource = this.nolanDataSet;
            // 
            // hr_employeeTableAdapter
            // 
            this.hr_employeeTableAdapter.ClearBeforeFill = true;
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.BackgroundColor = System.Drawing.SystemColors.ControlDarkDark;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idDataGridViewTextBoxColumn,
            this.name,
            this.work_email,
            this.user_id});
            this.dataGridView1.DataSource = this.hremployeeBindingSource1;
            this.dataGridView1.Location = new System.Drawing.Point(216, 111);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(443, 150);
            this.dataGridView1.TabIndex = 0;
            // 
            // hremployeeBindingSource1
            // 
            this.hremployeeBindingSource1.DataMember = "hr_employee";
            this.hremployeeBindingSource1.DataSource = this.nolanDataSet;
            // 
            // idDataGridViewTextBoxColumn
            // 
            this.idDataGridViewTextBoxColumn.DataPropertyName = "id";
            this.idDataGridViewTextBoxColumn.HeaderText = "id";
            this.idDataGridViewTextBoxColumn.Name = "idDataGridViewTextBoxColumn";
            // 
            // name
            // 
            this.name.DataPropertyName = "name";
            this.name.HeaderText = "name";
            this.name.Name = "name";
            // 
            // work_email
            // 
            this.work_email.DataPropertyName = "work_email";
            this.work_email.HeaderText = "work_email";
            this.work_email.Name = "work_email";
            // 
            // user_id
            // 
            this.user_id.DataPropertyName = "user_id";
            this.user_id.HeaderText = "user_id";
            this.user_id.Name = "user_id";
            // 
            // LangileakDLL
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.Controls.Add(this.dataGridView1);
            this.Name = "LangileakDLL";
            this.Size = new System.Drawing.Size(962, 503);
            ((System.ComponentModel.ISupportInitialize)(this.nolanDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.appusersBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.hremployeeBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.hremployeeBindingSource1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private NolanDataSet nolanDataSet;
        private System.Windows.Forms.BindingSource appusersBindingSource;
        private NolanDataSetTableAdapters.app_usersTableAdapter app_usersTableAdapter;
        private System.Windows.Forms.BindingSource hremployeeBindingSource;
        private NolanDataSetTableAdapters.hr_employeeTableAdapter hr_employeeTableAdapter;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn idDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn name;
        private System.Windows.Forms.DataGridViewTextBoxColumn work_email;
        private System.Windows.Forms.DataGridViewTextBoxColumn user_id;
        private System.Windows.Forms.BindingSource hremployeeBindingSource1;
    }
}
