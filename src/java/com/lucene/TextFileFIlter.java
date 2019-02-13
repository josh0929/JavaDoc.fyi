/*
 * 
 * Description:
 * 
 * 
 * @author Joshua Suarez
 * 
 * Course: COP3337 Computer Programming II
 * and open the template in the editor.
 * Instructor: Greg Shaw
 * File name:
 * Assignment: 
 * Panther ID: 6041323
 */
package com.lucene;

import java.io.File;
import java.io.FileFilter;


public class TextFileFIlter implements FileFilter
{
	@Override
	public boolean accept(File pathname)
	{
		return pathname.getName().toLowerCase().endsWith(".docx");
	}
}
