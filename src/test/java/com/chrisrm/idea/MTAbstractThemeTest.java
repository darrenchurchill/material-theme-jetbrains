/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Chris Magnussen and Elior Boukhobza
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package com.chrisrm.idea;

import com.intellij.ide.ui.laf.LafManagerImpl;
import com.intellij.ui.JBColor;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.Objects;


public class MTAbstractThemeTest extends MTFixtureTestCase {

  private final MTAbstractTheme darkAbstractTheme = new MTAbstractTheme() {
    @Override
    public ColorUIResource getBackgroundColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getForegroundColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getTextColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getSelectionBackgroundColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getSelectionForegroundColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getButtonColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getSecondaryBackgroundColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getDisabledColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getContrastColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getTableSelectedColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getSecondBorderColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getHighlightColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getTreeSelectionColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getNotificationsColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getAccentColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public ColorUIResource getExcludedColorString() {
      return new ColorUIResource(0x000000);
    }

    @Override
    public String getThemeId() {
      return "test";
    }

    @Override
    public int getOrder() {
      return 0;
    }
  };
  private final MTAbstractTheme lightAbstractTheme = new MTAbstractTheme() {
    @Override
    public ColorUIResource getBackgroundColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getForegroundColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getTextColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getSelectionBackgroundColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getSelectionForegroundColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getButtonColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getSecondaryBackgroundColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getDisabledColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getContrastColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getTableSelectedColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getSecondBorderColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getHighlightColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getTreeSelectionColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getNotificationsColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public boolean isCustom() {
      return true;
    }

    @Override
    public ColorUIResource getAccentColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public ColorUIResource getExcludedColorString() {
      return new ColorUIResource(0xFFFFFF);
    }

    @Override
    public String getThemeId() {
      return "test";
    }

    @Override
    public int getOrder() {
      return 0;
    }
  };

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
  }

  @Override
  public void tearDown() throws Exception {
    MTConfig.getInstance().resetSettings();
    MTThemeManager.getInstance().activate();
    super.tearDown();
  }

  @Test
  public void testGetSelectionBackground() {
    // Verify the results
    assertEquals("should have custom theme selection background", darkAbstractTheme.getSelectionBackgroundColorString(),
        darkAbstractTheme.getSelectionBackgroundColorString());
    assertEquals("should have light custom theme selection background", lightAbstractTheme.getSelectionBackgroundColorString(),
        lightAbstractTheme.getSelectionBackgroundColorString());
  }

  @Test
  public void testGetDisabled() {
    // Verify the results
    assertEquals("should have custom theme disabled color", "2E3C43", darkAbstractTheme.getDisabledColorString());
    assertEquals("should have light custom theme disabled color", "eae8e8", lightAbstractTheme.getDisabledColorString());
  }

  @Test
  public void testActivateDarkLaf() {
    darkAbstractTheme.activate();
    assertTrue(Objects.requireNonNull(LafManagerImpl.getTestInstance().getCurrentLookAndFeel()).getClassName().contains("DarculaLaf"));
    assertFalse(JBColor.isBright());
    assertTrue("Should be wearing the Dark Laf", UIManager.getLookAndFeel().getDescription().contains("Dark Material"));
  }

  @Test
  public void testActivateLightLaf() {
    lightAbstractTheme.activate();
    assertTrue(Objects.requireNonNull(LafManagerImpl.getTestInstance().getCurrentLookAndFeel()).getClassName().contains("IntelliJLaf"));
    assertTrue(JBColor.isBright());
    assertTrue("Should be wearing the Light Laf", UIManager.getLookAndFeel().getDescription().contains("Light Material"));
  }

  @Test
  public void testActivate() {
    final Object oldColor = UIManager.get("material.background");
    darkAbstractTheme.activate();
    final Color newColor = UIManager.getColor("material.background");
    assertNotSame("It should have activated the theme resources", newColor, oldColor);
  }

  @Test
  public void testIsCustom() {
    assertFalse("dark theme should not be custom", darkAbstractTheme.isCustom());
    assertTrue("light theme should be custom", lightAbstractTheme.isCustom());
  }

  @Test
  public void testGetPrimaryColor() {
    assertEquals("should return dark material primary color", UIManager.getColor("material.primaryColor"),
        darkAbstractTheme.getPrimaryColor());
    assertEquals("should return light material primary color", UIManager.getColor("material.primaryColor"),
        lightAbstractTheme.getPrimaryColor());
  }

  @Test
  public void testDarculaGetPrimaryColor() {
    // Setup
    MTConfig.getInstance().setIsMaterialTheme(false);
    darkAbstractTheme.activate();

    // Run the test
    final Color result = darkAbstractTheme.getPrimaryColor();

    // Verify the results
    assertEquals("should return darcula primary color", UIManager.getColor("darcula.primary"), result);
  }

  @Test
  public void testLightGetPrimaryColor() {
    // Setup
    MTConfig.getInstance().setIsMaterialTheme(false);
    lightAbstractTheme.activate();

    // Run the test
    final Color result = lightAbstractTheme.getPrimaryColor();

    // Verify the results
    assertEquals("should return light primary color", UIManager.getColor("intellijlaf.primary"), result);
  }

  @Test
  public void testGetBackgroundColor() {
    // Verify the results
    assertEquals("should return dark material background color", UIManager.getColor("material.background"),
        darkAbstractTheme.getBackgroundColor());
    assertEquals("should return light material background color", UIManager.getColor("material.background"),
        lightAbstractTheme.getBackgroundColor());
  }

  @Test
  public void testDarculaGetBackgroundColor() {
    // setup
    MTConfig.getInstance().setIsMaterialTheme(false);
    darkAbstractTheme.activate();

    // Run the test
    final Color result = darkAbstractTheme.getBackgroundColor();

    // Verify the results
    assertEquals("should return darcula background color", UIManager.getColor("darcula.background"), result);
  }

  @Test
  public void testLightGetBackgroundColor() {
    // setup
    MTConfig.getInstance().setIsMaterialTheme(false);
    lightAbstractTheme.activate();

    // Run the test
    final Color result = lightAbstractTheme.getBackgroundColor();

    // Verify the results
    assertEquals("should return darcula background color", UIManager.getColor("intellijlaf.background"), result);
  }

  @Test
  public void testGetForegroundColor() {
    assertEquals("should return dark material foreground", UIManager.getColor("material.foreground"),
        darkAbstractTheme.getForegroundColor());
    assertEquals("should return light material foreground", UIManager.getColor("material.foreground"),
        lightAbstractTheme.getForegroundColor());
  }

  @Test
  public void testDarculaGetForegroundColor() {
    // Run the test
    MTConfig.getInstance().setIsMaterialTheme(false);
    darkAbstractTheme.activate();

    final Color result = darkAbstractTheme.getForegroundColor();

    // Verify the results
    assertEquals("should return darcula foreground color", UIManager.getColor("darcula.foreground"), result);
  }

  @Test
  public void testLightGetForegroundColor() {
    // Run the test
    MTConfig.getInstance().setIsMaterialTheme(false);
    lightAbstractTheme.activate();

    final Color result = lightAbstractTheme.getForegroundColor();

    // Verify the results
    assertEquals("should return darcula foreground color", UIManager.getColor("intellijlaf.foreground"), result);
  }

  @Test
  public void testGetContrastColor() {
    assertEquals("should return dark material contrast", UIManager.getColor("material.contrast"), darkAbstractTheme.getContrastColor());
    assertEquals("should return light material contrast", UIManager.getColor("material.contrast"), lightAbstractTheme.getContrastColor());
  }

  @Test
  public void testDarculaGetContrastColor() {
    // setup
    MTConfig.getInstance().setIsMaterialTheme(false);
    darkAbstractTheme.activate();

    // Run the test
    final Color result = darkAbstractTheme.getContrastColor();

    // Verify the results
    assertEquals("should return default contrast", UIManager.getColor("darcula.contrastColor"), result);
  }

  @Test
  public void testLightGetContrastColor() {
    // setup
    MTConfig.getInstance().setIsMaterialTheme(false);
    lightAbstractTheme.activate();

    // Run the test
    final Color result = lightAbstractTheme.getContrastColor();

    // Verify the results
    assertEquals("should return default contrast", UIManager.getColor("intellijlaf.contrastColor"), result);
  }
}
