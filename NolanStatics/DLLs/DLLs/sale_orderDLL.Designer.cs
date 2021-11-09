namespace DLLs
{
    partial class sale_orderDLL
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
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.idDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.amounttotalDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dateorderDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nameDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.partneridDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.useridDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.saleorderBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.nolanDataSet = new DLLs.NolanDataSet();
            this.sale_orderTableAdapter = new DLLs.NolanDataSetTableAdapters.sale_orderTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nolanDataSet)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idDataGridViewTextBoxColumn,
            this.amounttotalDataGridViewTextBoxColumn,
            this.dateorderDataGridViewTextBoxColumn,
            this.nameDataGridViewTextBoxColumn,
            this.partneridDataGridViewTextBoxColumn,
            this.useridDataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.saleorderBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(53, 3);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(642, 150);
            this.dataGridView1.TabIndex = 0;
            // 
            // idDataGridViewTextBoxColumn
            // 
            this.idDataGridViewTextBoxColumn.DataPropertyName = "id";
            this.idDataGridViewTextBoxColumn.HeaderText = "id";
            this.idDataGridViewTextBoxColumn.Name = "idDataGridViewTextBoxColumn";
            // 
            // amounttotalDataGridViewTextBoxColumn
            // 
            this.amounttotalDataGridViewTextBoxColumn.DataPropertyName = "amount_total";
            this.amounttotalDataGridViewTextBoxColumn.HeaderText = "amount_total";
            this.amounttotalDataGridViewTextBoxColumn.Name = "amounttotalDataGridViewTextBoxColumn";
            // 
            // dateorderDataGridViewTextBoxColumn
            // 
            this.dateorderDataGridViewTextBoxColumn.DataPropertyName = "date_order";
            this.dateorderDataGridViewTextBoxColumn.HeaderText = "date_order";
            this.dateorderDataGridViewTextBoxColumn.Name = "dateorderDataGridViewTextBoxColumn";
            // 
            // nameDataGridViewTextBoxColumn
            // 
            this.nameDataGridViewTextBoxColumn.DataPropertyName = "name";
            this.nameDataGridViewTextBoxColumn.HeaderText = "name";
            this.nameDataGridViewTextBoxColumn.Name = "nameDataGridViewTextBoxColumn";
            // 
            // partneridDataGridViewTextBoxColumn
            // 
            this.partneridDataGridViewTextBoxColumn.DataPropertyName = "partner_id";
            this.partneridDataGridViewTextBoxColumn.HeaderText = "partner_id";
            this.partneridDataGridViewTextBoxColumn.Name = "partneridDataGridViewTextBoxColumn";
            // 
            // useridDataGridViewTextBoxColumn
            // 
            this.useridDataGridViewTextBoxColumn.DataPropertyName = "user_id";
            this.useridDataGridViewTextBoxColumn.HeaderText = "user_id";
            this.useridDataGridViewTextBoxColumn.Name = "useridDataGridViewTextBoxColumn";
            // 
            // saleorderBindingSource
            // 
            this.saleorderBindingSource.DataMember = "sale_order";
            this.saleorderBindingSource.DataSource = this.nolanDataSet;
            // 
            // nolanDataSet
            // 
            this.nolanDataSet.DataSetName = "NolanDataSet";
            this.nolanDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // sale_orderTableAdapter
            // 
            this.sale_orderTableAdapter.ClearBeforeFill = true;
            // 
            // sale_order
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.dataGridView1);
            this.Name = "sale_order";
            this.Size = new System.Drawing.Size(787, 495);
 
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nolanDataSet)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn idDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn amounttotalDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn dateorderDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn nameDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn partneridDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn useridDataGridViewTextBoxColumn;
        private System.Windows.Forms.BindingSource saleorderBindingSource;
        private NolanDataSet nolanDataSet;
        private NolanDataSetTableAdapters.sale_orderTableAdapter sale_orderTableAdapter;
    }
}
