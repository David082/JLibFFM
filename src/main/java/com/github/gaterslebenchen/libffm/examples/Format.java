/*
 * JLibFFM
 *
 * Copyright (c) 2017, Jinbo Chen(gaterslebenchen@gmail.com)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 *  - Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the docume
 *    ntation and/or other materials provided with the distribution.
 *  - Neither the name of the <ORGANIZATION> nor the names of its contributors may be used to endorse or promote products derived from this
 *    software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUD
 * ING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN N
 * O EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR C
 * ONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR P
 * ROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 *  TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBI
 *  LITY OF SUCH DAMAGE.
 */
package com.github.gaterslebenchen.libffm.examples;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.github.gaterslebenchen.libffm.tools.Util;

public class Format {
	public static void main(String[] args) throws Exception
	{
		String usage = "usage: com.github.gaterslebenchen.libffm.examples.Format inputfilepath outputfilepath";
		if (args.length != 2) {
			System.out.println(usage);
			System.exit(-1);
		}
		
		PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(args[1])));
		
        
        BufferedReader br = null;
        try
        {
        	String temp = null;
			br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
			while ((temp = br.readLine()) != null) {
				String[] strs = Util.split(temp, " ");
				writer.append(strs[0]);
				for(int i=1;i<strs.length;i++)
				{
					writer.append(" " + i + ":" + strs[i] + ":1");
				}
				writer.println();
			}
        }
        catch(Exception e)
		{
			throw e;
		}
		finally
		{
			try
			{
				if(br!=null)
				{
					br.close();
				}
				if(writer!=null)
				{
					writer.flush();
					writer.close();
				}
			}
			catch(Exception e)
			{
				//ignore
			}
		}
	}
}
