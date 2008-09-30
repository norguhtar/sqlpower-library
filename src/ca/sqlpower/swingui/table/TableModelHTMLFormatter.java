/*
 * Copyright (c) 2008, SQL Power Group Inc.
 * 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in
 *       the documentation and/or other materials provided with the
 *       distribution.
 *     * Neither the name of SQL Power Group Inc. nor the names of its
 *       contributors may be used to endorse or promote products derived
 *       from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package ca.sqlpower.swingui.table;

import java.io.PrintWriter;

import javax.swing.table.TableModel;

/**
 * This class exports TableModels to a very basic HTML table.
 */
public class TableModelHTMLFormatter {
	
	/**
	 * Converts the given model into a HTML file and writes it to the output
	 * stream.
	 */	
	public static void formatToStream(TableModel model, PrintWriter out) {
		int[] allRows = new int[model.getRowCount()];
		for (int i = 0; i < model.getRowCount(); i++) {
			allRows[i] = i;
		}
		formatToStream(model, out, allRows);
	}
	
	/**
	 * Outputs a table in HTML that represents the TableModel. Only the rows
	 * given will be written to the file.
	 */
	public static void formatToStream(TableModel model, PrintWriter out, int[] selectedRows) {
		out.println("<table>");
		out.println(" <tr>");
		for (int i = 0; i < model.getColumnCount(); i++) {
			out.print("  <th>");
			out.print(model.getColumnName(i));
			out.println("</th>");
		}
		out.println(" </tr>");
		
		for (int i = 0; i < selectedRows.length; i++) {
			out.println(" <tr>");
			
			for (int j = 0; j < model.getColumnCount(); j++ ) {
				out.print("  <td>");
				out.print(model.getValueAt(selectedRows[i], j).toString());
				out.println("</td>");
			}
			out.println(" </tr>");
		}
		out.println("</table>");		
	}

}